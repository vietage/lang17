package com.vietage.lang17.parser.ast.expression;

import com.vietage.lang17.parser.ast.Type;

public abstract class ConstantExpression implements Expression {

    protected abstract Type getType();
}
