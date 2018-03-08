package com.vietage.lang17.interpreter.result;

import com.vietage.lang17.parser.ast.Type;

public class FloatArrayResult extends Result {

    private final double[] value;

    public FloatArrayResult(Type type, double[] value) {
        super(type);
        this.value = value;
    }

    @Override
    public double[] getFloatArray() {
        return value;
    }
}
