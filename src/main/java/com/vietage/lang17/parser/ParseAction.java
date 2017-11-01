package com.vietage.lang17.parser;

import com.vietage.lang17.parser.ast.ASTElement;

@FunctionalInterface
public interface ParseAction<A extends ASTElement> {
    void doAction(A element);
}
