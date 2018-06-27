package com.vietage.lang17.interpreter.result;

import com.vietage.lang17.parser.ast.Type;

public class IntegerResult extends Result {

    private long value;

    public IntegerResult(long value) {
        super(Type.INTEGER);
        this.value = value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public long getInteger() {
        return value;
    }
}
