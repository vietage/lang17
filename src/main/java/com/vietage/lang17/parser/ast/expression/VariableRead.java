package com.vietage.lang17.parser.ast.expression;

import com.vietage.lang17.lexer.Position;
import com.vietage.lang17.parser.ast.PositionalElement;

public class VariableRead implements Expression, PositionalElement {

    private final String name;
    private final Position position;

    public VariableRead(String name, Position position) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
