package com.vietage.lang17.parser.ast.expression;

import com.vietage.lang17.lexer.Position;
import com.vietage.lang17.parser.ast.PositionalElement;

import java.util.ArrayList;
import java.util.List;

public class OrExpression implements Expression, PositionalElement {

    private final Position position;
    private final List<Expression> expressions = new ArrayList<>();

    public OrExpression(Position position) {
        this.position = position;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public OperatorPrecedence getOperatorPrecedence() {
        return OperatorPrecedence.OR;
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
