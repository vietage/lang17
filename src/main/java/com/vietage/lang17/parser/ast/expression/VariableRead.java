package com.vietage.lang17.parser.ast.expression;

public class VariableRead implements Expression {

    private final String name;

    public VariableRead(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public OperatorPrecedence getOperatorPrecedence() {
        return OperatorPrecedence.VAL;
    }

    public String getName() {
        return name;
    }

}
