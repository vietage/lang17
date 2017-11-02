package com.vietage.lang17.parser.ast.statement;

import com.vietage.lang17.parser.ast.expression.Expression;

public class VariableAssignment extends Statement {

    private final String name;
    private final Expression expression;
}
