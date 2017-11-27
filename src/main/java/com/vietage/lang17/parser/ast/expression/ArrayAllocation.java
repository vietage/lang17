package com.vietage.lang17.parser.ast.expression;

import com.vietage.lang17.parser.ast.Type;

public class ArrayAllocation extends Expression {

    private final Type type;
    private Expression sizeExpression;

    public ArrayAllocation(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public Expression getSizeExpression() {
        return sizeExpression;
    }

    public void setSizeExpression(Expression sizeExpression) {
        this.sizeExpression = sizeExpression;
    }
}
