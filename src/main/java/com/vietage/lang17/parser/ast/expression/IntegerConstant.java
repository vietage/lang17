package com.vietage.lang17.parser.ast.expression;

import com.vietage.lang17.parser.ast.Type;

public class IntegerConstant extends NumberConstant {

    private final long value;

    public IntegerConstant(long value) {
        this.value = value;
    }

    @Override
    protected Type getType() {
        return Type.INTEGER;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
