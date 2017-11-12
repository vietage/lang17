package com.vietage.lang17.parser.ast.expression;

public class EqualityExpression extends Expression {

    private final EqualityOperator operator;
    private Expression leftExpression;
    private Expression rightExpression;

    public EqualityExpression(EqualityOperator operator) {
        this.operator = operator;
    }

    public EqualityOperator getOperator() {
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
