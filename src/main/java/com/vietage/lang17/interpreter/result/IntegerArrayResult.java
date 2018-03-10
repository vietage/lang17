package com.vietage.lang17.interpreter.result;

import com.vietage.lang17.parser.ast.Type;

public class IntegerArrayResult extends Result {

    private final int[] value;

    public IntegerArrayResult(int[] value) {
        super(Type.INTEGER_ARRAY);
        this.value = value;
    }

    @Override
    public int[] getIntegerArray() {
        return value;
    }
}
