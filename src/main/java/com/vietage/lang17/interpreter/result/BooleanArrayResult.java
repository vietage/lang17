package com.vietage.lang17.interpreter.result;

import com.vietage.lang17.parser.ast.Type;

import java.util.Arrays;

public class BooleanArrayResult extends Result {

    private final boolean[] value;

    public BooleanArrayResult(boolean[] value) {
        super(Type.BOOLEAN_ARRAY);
        this.value = value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isBooleanArray() {
        return true;
    }

    @Override
    public boolean[] getBooleanArray() {
        return value;
    }

    @Override
    public String toString() {
        return "BooleanArrayResult{" +
                "value=" + Arrays.toString(value) +
                '}';
    }
}
