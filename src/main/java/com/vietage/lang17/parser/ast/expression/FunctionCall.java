package com.vietage.lang17.parser.ast.expression;

import com.vietage.lang17.parser.ast.statement.Statement;

import java.util.List;

public class FunctionCall implements Statement, Expression {

    private final String name;
    private List<Expression> arguments;

    public FunctionCall(String name) {
        this.name = name;
    }

    @Override
    public void accept(Statement.Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(Expression.Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public OperatorPrecedence getOperatorPrecedence() {
        return OperatorPrecedence.VAL;
    }

    public String getName() {
        return name;
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    public void setArguments(List<Expression> arguments) {
        this.arguments = arguments;
    }
}
