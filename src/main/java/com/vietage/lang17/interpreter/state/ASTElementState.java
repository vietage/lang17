package com.vietage.lang17.interpreter.state;

import com.vietage.lang17.parser.ast.ASTElement;

public interface ASTElementState extends State {

    ASTElement getAstElement();
}
