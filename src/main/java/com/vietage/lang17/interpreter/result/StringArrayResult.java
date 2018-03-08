package com.vietage.lang17.interpreter.result;

import com.vietage.lang17.parser.ast.Type;

public class StringArrayResult extends Result {

    private final String[] value;

    public StringArrayResult(Type type, String[] value) {
        super(type);
        this.value = value;
    }

    @Override
    public String[] getStringArray() {
        return value;
    }
}
