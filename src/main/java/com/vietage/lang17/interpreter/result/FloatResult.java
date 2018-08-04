package com.vietage.lang17.interpreter.result;

import com.vietage.lang17.parser.ast.Type;

public class FloatResult extends Result {

    private final double value;

    public FloatResult(double value) {
        super(Type.FLOAT);
        this.value = value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isFloat() {
        return true;
    }

    @Override
    public double getFloat() {
        return value;
    }

    @Override
    public String toString() {
        return "FloatResult{" +
                "value=" + value +
                '}';
    }
}
