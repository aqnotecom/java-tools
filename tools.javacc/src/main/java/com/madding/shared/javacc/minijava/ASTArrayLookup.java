package com.madding.shared.javacc.minijava;
/* Generated By:JJTree: Do not edit this line. ASTArrayLookup.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTArrayLookup extends SimpleNode {
  public ASTArrayLookup(int id) {
    super(id);
  }

  public ASTArrayLookup(MiniJavaParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MiniJavaParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=b39debb9874d08edd4c4bade323fad92 (do not edit this line) */
