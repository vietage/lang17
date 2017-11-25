package com.vietage.lang17.parser.ast.expression;

public class MultiplicationExpression extends Expression {

    private final MultiplicationOperator operator;
    private Expression leftExpression;
    private Expression rightExpression;

    public MultiplicationExpression(MultiplicationOperator operator) {
        this.operator = operator;
    }

    public MultiplicationOperator getOperator() {
        return operator;
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public void setLeftExpression(Expression leftExpression) {
        this.leftExpression = leftExpression;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }

    public void setRightExpression(Expression rightExpression) {
        this.rightExpression = rightExpression;
    }
}
