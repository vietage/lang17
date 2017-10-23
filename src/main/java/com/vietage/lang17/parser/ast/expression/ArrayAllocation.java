package com.vietage.lang17.parser.ast.expression;

import com.vietage.lang17.parser.ast.Type;

public class ArrayAllocation extends Expression {
    private final Type type;
    private final Expression sizeExpression;
}
