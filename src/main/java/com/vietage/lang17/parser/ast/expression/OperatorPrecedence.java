package com.vietage.lang17.parser.ast.expression;

public enum OperatorPrecedence {

    OR,
    AND,
    EQUAL,
    REL,
    ADD,
    MUL,
    NOT,
    VAL;

    public boolean less(OperatorPrecedence operatorPrecedence) {
        return this.ordinal() < operatorPrecedence.ordinal();
    }
}
