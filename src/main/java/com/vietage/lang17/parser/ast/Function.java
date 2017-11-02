package com.vietage.lang17.parser.ast;

import com.vietage.lang17.parser.ast.statement.Statement;

import java.util.ArrayList;
import java.util.List;

public class Function extends ASTElement {

    private final String name;
    private final Type returnType;
    private final List<Argument> arguments = new ArrayList<>();
    private final List<Statement> statements = new ArrayList<>();

    public Function(String name, Type returnType) {
        this.name = name;
        this.returnType = returnType;
    }

    public String getName() {
        return name;
    }

    public Type getReturnType() {
        return returnType;
    }

    public List<Argument> getArguments() {
        return arguments;
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
