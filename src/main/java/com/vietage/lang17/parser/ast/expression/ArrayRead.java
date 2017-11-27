package com.vietage.lang17.parser.ast.expression;

public class ArrayRead extends Expression {

    private final String name;
    private Expression indexExpression;

    public ArrayRead(String name) {
        this.name = name;
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
