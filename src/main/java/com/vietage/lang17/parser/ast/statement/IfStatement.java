package com.vietage.lang17.parser.ast.statement;

import com.vietage.lang17.parser.ast.expression.Expression;

import java.util.List;

public class IfStatement extends Statement {

    private final Expression condition;
    private final List<Statement> statements;
    private final List<Statement> elseStatements;
}
