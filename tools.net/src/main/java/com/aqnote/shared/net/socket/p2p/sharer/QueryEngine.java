/*
 * Copyright (C) 2013-2016 aqnote.com<madding.lip@gmail.com>. 
 * This library is free software; you can redistribute it and/or modify it under the terms of
 * the GNU Lesser General Public License as published by the Free Software Foundation;
 */
package com.aqnote.shared.net.socket.p2p.sharer;

import java.util.Hashtable;
import java.util.Set;

import com.aqnote.shared.net.socket.p2p.Peer;
import com.aqnote.shared.net.socket.p2p.util.LoggerUtil;

public class QueryEngine extends Thread {

    private SharerNode peer;
    private String     ret_pid;
    private String     key;
    private int        timeToLive;

    public QueryEngine(SharerNode peer, String pid, String key, int ttl){
        this.peer = peer;
        this.ret_pid = pid;
        this.key = key;
        this.timeToLive = ttl;
    }

    public void run() {
        // Search for the file key among all the nodes in the list
        Hashtable<String, String> tableFiles = this.peer.getTableFiles();
        Set<String> files = tableFiles.keySet();
        for (String fileName : files) {
            if (fileName.indexOf(key) >= 0) {
                String pid = tableFiles.get(fileName);
                String data[] = this.ret_pid.split(":");
                String host = data[0];
                int port = Integer.parseInt(data[1]);
                Peer p = new Peer(this.ret_pid, host, port);
                String replyData = fileName + " " + pid;
                this.peer.connectAndSend(p, SharerMessage.QUERY_RESPONSE, replyData, true);
                LoggerUtil.getLogger().fine("Sent QRESP " + p + " " + replyData);
                return;

            }
        }

        // In case the file is not found, try to propagate till time to live == 0
        if (this.timeToLive > 0) {
            String msgData = String.format("%s %s %d", this.ret_pid, this.key, this.timeToLive - 1);
            for (String nextPID : this.peer.getPeerKeys()) {
                this.peer.sendToPeer(nextPID, SharerMessage.QUERY, msgData, true);
            }
        }
    }
}
