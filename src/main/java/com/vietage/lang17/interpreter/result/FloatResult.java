package com.vietage.lang17.interpreter.result;

import com.vietage.lang17.parser.ast.Type;

public class FloatResult extends Result {

    private final double value;

    public FloatResult(double value) {
        super(Type.FLOAT);
        this.value = value;
    }

    @Override
    public double getFloat() {
        return value;
    }
}
