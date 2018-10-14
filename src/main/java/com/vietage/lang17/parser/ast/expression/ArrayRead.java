package com.vietage.lang17.parser.ast.expression;

import com.vietage.lang17.lexer.Position;
import com.vietage.lang17.parser.ast.PositionalElement;

public class ArrayRead implements Expression, PositionalElement {

    private final String name;
    private final Position position;
    private Expression indexExpression;

    public ArrayRead(String name, Position position) {
        this.position = position;
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public OperatorPrecedence getOperatorPrecedence() {
        return OperatorPrecedence.VAL;
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

    @Override
    public Position getPosition() {
        return position;
    }
}
