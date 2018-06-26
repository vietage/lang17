package com.vietage.lang17.interpreter.result;

import com.vietage.lang17.parser.ast.Type;

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
    public boolean[] getBooleanArray() {
        return value;
    }
}
