package com.vietage.lang17.parser.ast;

import com.vietage.lang17.parser.ast.statement.Statement;

import java.util.List;

public class Function {
    private final Type returnType;
    private final List<Argument> arguments;
    private final List<Statement> statements;
}
