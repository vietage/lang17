package com.vietage.lang17.interpreter.result;

import com.vietage.lang17.parser.ast.Type;

public class IntegerArrayResult extends Result {

    private final long[] value;

    public IntegerArrayResult(long[] value) {
        super(Type.INTEGER_ARRAY);
        this.value = value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public long[] getIntegerArray() {
        return value;
    }
}
