package com.madding.shared.javacc.minijava;
/* Generated By:JJTree: Do not edit this line. ASTExpressionRest.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTExpressionRest extends SimpleNode {
  public ASTExpressionRest(int id) {
    super(id);
  }

  public ASTExpressionRest(MiniJavaParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MiniJavaParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=8fc327733376f194a3158b83b5a34890 (do not edit this line) */
