/*
 * Copyright (C) 2013-2016 Peng Li<aqnote@qq.com>.
 * This library is free software; you can redistribute it and/or modify it under the terms of
 * the GNU Lesser General Public License as published by the Free Software Foundation;
 */
package com.aqnote.shared.javacc.math.n;
/* Generated By:JJTree: Do not edit this line. ASTMult.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTMult extends SimpleNode {
  public ASTMult(int id) {
    super(id);
  }

  public ASTMult(eg4 p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(eg4Visitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=01d0668bfed9e007676fa454e73227ac (do not edit this line) */
