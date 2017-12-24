package com.vietage.lang17.parser.ast.expression;

import com.vietage.lang17.parser.ast.Type;

public class FloatConstant extends NumberConstant {

    private final double value;

    public FloatConstant(double value) {
        this.value = value;
    }

    @Override
    protected Type getType() {
        return Type.FLOAT;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public double getValue() {
        return value;
    }
}
