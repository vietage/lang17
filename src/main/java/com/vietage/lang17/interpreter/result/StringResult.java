package com.vietage.lang17.interpreter.result;

import com.vietage.lang17.parser.ast.Type;

public class StringResult extends Result {

    private final String value;

    public StringResult(Type type, String value) {
        super(type);
        this.value = value;
    }

    @Override
    public String getString() {
        return value;
    }
}
