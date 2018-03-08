package com.vietage.lang17.interpreter.result;

import com.vietage.lang17.parser.ast.Type;

public class IntegerArrayResult extends Result {

    private final int[] value;

    public IntegerArrayResult(Type type, int[] value) {
        super(type);
        this.value = value;
    }

    @Override
    public int[] getIntegerArray() {
        return value;
    }
}
