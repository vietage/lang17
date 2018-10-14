package com.vietage.lang17.parser.ast.expression;

import com.vietage.lang17.lexer.Position;
import com.vietage.lang17.parser.ast.PositionalElement;
import com.vietage.lang17.parser.ast.Type;

public class ArrayAllocation implements Expression, PositionalElement {

    private final Type type;
    private final Position position;
    private Expression sizeExpression;

    public ArrayAllocation(Type type, Position position) {
        this.type = type;
        this.position = position;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public OperatorPrecedence getOperatorPrecedence() {
        return OperatorPrecedence.VAL;
    }

    public Type getType() {
        return type;
    }

    public Expression getSizeExpression() {
        return sizeExpression;
    }

    public void setSizeExpression(Expression sizeExpression) {
        this.sizeExpression = sizeExpression;
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
