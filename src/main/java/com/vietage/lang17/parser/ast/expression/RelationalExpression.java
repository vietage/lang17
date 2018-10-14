package com.vietage.lang17.parser.ast.expression;

import com.vietage.lang17.lexer.Position;

public class RelationalExpression implements TwoOperandsExpression {

    private final RelationalOperator operator;
    private final Position position;
    private Expression leftExpression;
    private Expression rightExpression;

    public RelationalExpression(RelationalOperator operator, Position position) {
        this.operator = operator;
        this.position = position;
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

    @Override
    public Position getPosition() {
        return position;
    }
}
