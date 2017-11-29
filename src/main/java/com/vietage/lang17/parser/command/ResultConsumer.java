package com.vietage.lang17.parser.command;

import com.vietage.lang17.parser.ast.ASTElement;

@FunctionalInterface
public interface ResultConsumer<A extends ASTElement> {

    void consume(A element);
}
