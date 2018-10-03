package com.vietage.lang17.parser.ast.expression;

import com.vietage.lang17.lexer.Position;
import com.vietage.lang17.parser.ast.statement.Statement;

import java.util.Collections;
import java.util.List;

public class FunctionCall extends Statement implements Expression {

    private final String name;
    private List<Expression> arguments = Collections.emptyList();

    public FunctionCall(String name) {
        super(null);
        this.name = name;
    }

    public FunctionCall(String name, Position position) {
        super(position);
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
