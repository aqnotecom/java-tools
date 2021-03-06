/*
 * Copyright (C) 2013-2016 Peng Li<aqnote@qq.com>.
 * This library is free software; you can redistribute it and/or modify it under the terms of
 * the GNU Lesser General Public License as published by the Free Software Foundation;
 */
package com.aqnote.shared.test.cert;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSAKeyPairGenDemo {

    public final static int PUBLIC_KEY  = 0;

    public final static int PRIVATE_KEY = 1;

    public static KeyPair getRSAKeyPair(int keySize) {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            SecureRandom random = new SecureRandom();
            keyGen.initialize(keySize, random);

            KeyPair pair = keyGen.generateKeyPair();
            return pair;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static boolean SaveKeyFile(KeyPair keyPair, String keyFile, int keyType) {

        boolean succ = true;
        // File fKey = new File(keyFile);
        FileOutputStream os = null;

        try {
            if (keyType != 1 && keyType != 0) {
                throw new Exception("Invalid   keyType!");
            }
            os = new FileOutputStream(keyFile);
            Key key = (keyType == PUBLIC_KEY ? (Key) keyPair.getPublic() : (Key) keyPair.getPrivate());
            os.write(key.getEncoded());

            // ObjectOutputStream objOs = new ObjectOutputStream(os);
            // objOs.writeObject((keyType == PUBLIC_KEY ? (Key) keyPair
            // .getPublic() : (Key) keyPair.getPrivate()));
            // objOs.close();
        } catch (Exception e) {
            e.printStackTrace();
            succ = false;
        }
        return succ;

    }

    @SuppressWarnings("unused")
    public static Key LoadKeyObjFromFile(boolean ispk, String keyFile) {
        Key key = null;
        FileInputStream is = null;
        ObjectInputStream objIs = null;

        try {
            is = new FileInputStream(keyFile);
            byte[] buf = new byte[is.available()];
            KeyFactory kf = KeyFactory.getInstance("RSA");
            is.read(buf);
            EncodedKeySpec ks;
            if (ispk) {
                ks = new PKCS8EncodedKeySpec(buf);

            } else {
                ks = new X509EncodedKeySpec(buf);
            }
            key = (!ispk ? (Key) kf.generatePublic(ks) : (Key) kf.generatePrivate(ks));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException iex) {
                iex.printStackTrace();
            }
        }
        return key;
    }
}
