package com.vietage.lang17.parser.ast.expression;

public class UnaryExpression implements Expression {

    private final UnaryOperator operator;
    private Expression expression;

    public UnaryExpression(UnaryOperator operator) {
        this.operator = operator;
    }

    public UnaryOperator getOperator() {
        return operator;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
