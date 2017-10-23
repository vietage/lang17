package com.vietage.lang17.parser.ast.expression;

import com.vietage.lang17.parser.ast.Type;

public class FloatConstant extends NumberConstant {
    private final double value;

    @Override
    protected Type getType() {
        return Type.FLOAT;
    }
}
