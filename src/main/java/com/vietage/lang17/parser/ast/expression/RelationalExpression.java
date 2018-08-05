package com.vietage.lang17.parser.ast.expression;

public class RelationalExpression implements Expression, TwoOperandsExpression {

    private final RelationalOperator operator;
    private Expression leftExpression;
    private Expression rightExpression;

    public RelationalExpression(RelationalOperator operator) {
        this.operator = operator;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public OperatorPrecedence getOperatorPrecedence() {
        return OperatorPrecedence.REL;
    }

    public RelationalOperator getOperator() {
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
