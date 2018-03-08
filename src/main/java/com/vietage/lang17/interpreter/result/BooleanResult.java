package com.vietage.lang17.interpreter.result;

import com.vietage.lang17.parser.ast.Type;

public class BooleanResult extends Result {

    private final boolean value;

    public BooleanResult(Type type, boolean value) {
        super(type);
        this.value = value;
    }

    @Override
    public boolean getBoolean() {
        return value;
    }
}
