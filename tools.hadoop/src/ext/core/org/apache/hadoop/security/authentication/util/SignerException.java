/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. See accompanying LICENSE file.
 */
/*
 * Copyright (C) 2013-2016 Peng Li<aqnote@qq.com>.
 * This library is free software; you can redistribute it and/or modify it under the terms of
 * the GNU Lesser General Public License as published by the Free Software Foundation;
 */ org.apache.hadoop.security.authentication.util;

/**
 * Exception thrown by {@link Signer} when a string signature is invalid.
 */
public class SignerException extends Exception {
  
  static final long serialVersionUID = 0;

  /**
   * Creates an exception instance.
   *
   * @param msg message for the exception.
   */
  public SignerException(String msg) {
    super(msg);
  }
}
