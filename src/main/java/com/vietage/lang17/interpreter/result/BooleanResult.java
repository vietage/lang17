package com.vietage.lang17.interpreter.result;

import com.vietage.lang17.parser.ast.Type;

public class BooleanResult extends Result {

    private final boolean value;

    public BooleanResult(boolean value) {
        super(Type.BOOLEAN);
        this.value = value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean getBoolean() {
        return value;
    }
}
