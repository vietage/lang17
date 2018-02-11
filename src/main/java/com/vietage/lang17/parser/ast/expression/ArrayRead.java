package com.vietage.lang17.parser.ast.expression;

public class ArrayRead implements Expression {

    private final String name;
    private Expression indexExpression;

    public ArrayRead(String name) {
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

    public Expression getIndexExpression() {
        return indexExpression;
    }

    public void setIndexExpression(Expression indexExpression) {
        this.indexExpression = indexExpression;
    }
}
