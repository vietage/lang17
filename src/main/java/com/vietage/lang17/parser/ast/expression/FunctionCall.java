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
    public void accept(Visitor visitor) {
        visitor.visit(this);
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
