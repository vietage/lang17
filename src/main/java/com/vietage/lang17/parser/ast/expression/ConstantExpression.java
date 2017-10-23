package com.vietage.lang17.parser.ast.expression;

import com.vietage.lang17.parser.ast.Type;

public abstract class ConstantExpression extends Expression {
    protected abstract Type getType();
}
