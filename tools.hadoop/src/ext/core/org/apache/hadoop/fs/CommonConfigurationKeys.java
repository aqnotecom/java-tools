/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Copyright (C) 2013-2016 Peng Li<aqnote@qq.com>.
 * This library is free software; you can redistribute it and/or modify it under the terms of
 * the GNU Lesser General Public License as published by the Free Software Foundation;
 */ org.apache.hadoop.fs;

/** 
 * This class contains constants for configuration keys used
 * in the common code.
 *
 */

public class CommonConfigurationKeys {
  
  /** See src/core/core-default.xml */
  public static final String  FS_DEFAULT_NAME_KEY = "fs.default.name";
  public static final String  FS_DEFAULT_NAME_DEFAULT = "file:///";

  /** See src/core/core-default.xml */
  public static final String  HADOOP_SECURITY_GROUP_MAPPING =
    "hadoop.security.group.mapping";
  /** See src/core/core-default.xml */
  public static final String  HADOOP_SECURITY_AUTHENTICATION =
    "hadoop.security.authentication";
  /** See src/core/core-default.xml */
  public static final String HADOOP_SECURITY_AUTHORIZATION =
    "hadoop.security.authorization";
  /** See src/core/core-default.xml */
  public static final String  HADOOP_SECURITY_SERVICE_USER_NAME_KEY = 
    "hadoop.security.service.user.name.key";
  /** See src/core/core-default.xml */
  public static final String HADOOP_SECURITY_TOKEN_SERVICE_USE_IP =
    "hadoop.security.token.service.use_ip";
  public static final boolean HADOOP_SECURITY_TOKEN_SERVICE_USE_IP_DEFAULT =
      true;
  
  public static final String IPC_SERVER_RPC_READ_THREADS_KEY =
                                        "ipc.server.read.threadpool.size";
  public static final int IPC_SERVER_RPC_READ_THREADS_DEFAULT = 1;

  public static final String  IO_NATIVE_LIB_AVAILABLE_KEY =
      "hadoop.native.lib";
  /** Default value for IO_NATIVE_LIB_AVAILABLE_KEY */
  public static final boolean IO_NATIVE_LIB_AVAILABLE_DEFAULT = true;

  /** Internal buffer size for Snappy compressor/decompressors */
  public static final String IO_COMPRESSION_CODEC_SNAPPY_BUFFERSIZE_KEY =
      "io.compression.codec.snappy.buffersize";

  /** Default value for IO_COMPRESSION_CODEC_SNAPPY_BUFFERSIZE_KEY */
  public static final int IO_COMPRESSION_CODEC_SNAPPY_BUFFERSIZE_DEFAULT =
      256 * 1024;
}

