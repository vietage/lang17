package com.vietage.lang17.parser.ast.statement;

import com.vietage.lang17.parser.ast.Type;
import com.vietage.lang17.parser.ast.expression.Expression;

public class VariableDefinition extends Statement {

    private final Type type;
    private final String name;
    private final Expression expression;
}
