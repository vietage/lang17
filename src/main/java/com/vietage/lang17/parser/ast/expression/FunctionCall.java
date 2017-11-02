package com.vietage.lang17.parser.ast.expression;

import com.vietage.lang17.parser.ast.statement.Statement;

import java.util.List;

public class FunctionCall extends Statement {

    private final String name;
    private final List<Expression> arguments;
}
