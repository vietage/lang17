package com.vietage.lang17.interpreter.result;

import com.vietage.lang17.parser.ast.Type;

import java.util.Arrays;

public class FloatArrayResult extends Result {

    private final double[] value;

    public FloatArrayResult(double[] value) {
        super(Type.FLOAT_ARRAY);
        this.value = value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isFloatArray() {
        return true;
    }

    @Override
    public double[] getFloatArray() {
        return value;
    }

    @Override
    public String toString() {
        return "FloatArrayResult{" +
                "value=" + Arrays.toString(value) +
                '}';
    }
}
