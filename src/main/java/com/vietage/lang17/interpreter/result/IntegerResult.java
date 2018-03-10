package com.vietage.lang17.interpreter.result;

import com.vietage.lang17.parser.ast.Type;

public class IntegerResult extends Result {

    private int value;

    public IntegerResult(int value) {
        super(Type.INTEGER);
        this.value = value;
    }

    @Override
    public int getInteger() {
        return value;
    }
}
