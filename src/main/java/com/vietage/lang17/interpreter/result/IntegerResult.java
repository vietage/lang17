package com.vietage.lang17.interpreter.result;

import com.vietage.lang17.parser.ast.Type;

public class IntegerResult extends Result {

    private final int value;

    public IntegerResult(Type type, int value) {
        super(type);
        this.value = value;
    }

    @Override
    public int getInteger() {
        return value;
    }
}
