package com.vietage.lang17.interpreter.result;

import com.vietage.lang17.parser.ast.Type;

public class BooleanArrayResult extends Result {

    private final boolean[] value;

    public BooleanArrayResult(Type type, boolean[] value) {
        super(type);
        this.value = value;
    }

    @Override
    public boolean[] getBooleanArray() {
        return value;
    }
}
