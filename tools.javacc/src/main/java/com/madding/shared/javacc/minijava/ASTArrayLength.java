package com.madding.shared.javacc.minijava;
/* Generated By:JJTree: Do not edit this line. ASTArrayLength.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTArrayLength extends SimpleNode {
  public ASTArrayLength(int id) {
    super(id);
  }

  public ASTArrayLength(MiniJavaParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MiniJavaParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=81a7a58a822e5139bd5e186003d09c7d (do not edit this line) */
