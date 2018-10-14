package com.vietage.lang17.parser.ast.expression;

import com.vietage.lang17.lexer.Position;
import com.vietage.lang17.parser.ast.PositionalElement;

public class UnaryExpression implements Expression, PositionalElement {

    private final UnaryOperator operator;
    private final Position position;
    private Expression expression;

    public UnaryExpression(UnaryOperator operator, Position position) {
        this.operator = operator;
        this.position = position;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public OperatorPrecedence getOperatorPrecedence() {
        return OperatorPrecedence.NOT;
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

    @Override
    public Position getPosition() {
        return position;
    }
}
