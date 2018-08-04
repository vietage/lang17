package com.vietage.lang17.interpreter.result;

import com.vietage.lang17.parser.ast.Type;

import java.util.Arrays;

public class StringArrayResult extends Result {

    private final String[] value;

    public StringArrayResult(String[] value) {
        super(Type.STRING_ARRAY);
        this.value = value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isStringArray() {
        return true;
    }

    @Override
    public String[] getStringArray() {
        return value;
    }

    @Override
    public String toString() {
        return "StringArrayResult{" +
                "value=" + Arrays.toString(value) +
                '}';
    }
}
