package com.vietage.lang17.parser.ast.expression;

public class EqualityExpression implements Expression, TwoOperandsExpression {

    private final EqualityOperator operator;
    private Expression leftExpression;
    private Expression rightExpression;

    public EqualityExpression(EqualityOperator operator) {
        this.operator = operator;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public OperatorPrecedence getOperatorPrecedence() {
        return OperatorPrecedence.EQUAL;
    }

    public EqualityOperator getOperator() {
        return operator;
    }

    @Override
    public Expression getLeftExpression() {
        return leftExpression;
    }

    public void setLeftExpression(Expression leftExpression) {
        this.leftExpression = leftExpression;
    }

    @Override
    public Expression getRightExpression() {
        return rightExpression;
    }

    public void setRightExpression(Expression rightExpression) {
        this.rightExpression = rightExpression;
    }
}
