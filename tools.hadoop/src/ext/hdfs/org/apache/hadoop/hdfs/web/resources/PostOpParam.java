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
 */ org.apache.hadoop.hdfs.web.resources;

import java.net.HttpURLConnection;

/** Http POST operation parameter. */
public class PostOpParam extends HttpOpParam<PostOpParam.Op> {
  /** Post operations. */
  public static enum Op implements HttpOpParam.Op {
    APPEND(HttpURLConnection.HTTP_OK),

    NULL(HttpURLConnection.HTTP_NOT_IMPLEMENTED);

    final int expectedHttpResponseCode;

    Op(final int expectedHttpResponseCode) {
      this.expectedHttpResponseCode = expectedHttpResponseCode;
    }

    @Override
    public Type getType() {
      return Type.POST;
    }

    @Override
    public boolean getDoOutput() {
      return true;
    }

    @Override
    public int getExpectedHttpResponseCode() {
      return expectedHttpResponseCode;
    }

    /** @return a URI query string. */
    public String toQueryString() {
      return NAME + "=" + this;
    }
  }

  private static final Domain<Op> DOMAIN = new Domain<PostOpParam.Op>(NAME, Op.class);

  /**
   * Constructor.
   * @param str a string representation of the parameter value.
   */
  public PostOpParam(final String str) {
    super(DOMAIN, DOMAIN.parse(str));
  }

  @Override
  public String getName() {
    return NAME;
  }
}