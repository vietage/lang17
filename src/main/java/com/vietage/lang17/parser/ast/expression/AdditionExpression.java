package com.vietage.lang17.parser.ast.expression;

public class AdditionExpression implements Expression {

    private final AdditionOperator operator;
    private Expression leftExpression;
    private Expression rightExpression;

    public AdditionExpression(AdditionOperator operator) {
        this.operator = operator;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public AdditionOperator getOperator() {
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
