package com.vietage.lang17.parser.ast.expression;

public class VariableRead implements Expression {

    private final String name;

    public VariableRead(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
