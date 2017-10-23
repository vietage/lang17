package com.vietage.lang17.parser.ast.expression;

import com.vietage.lang17.parser.ast.Type;

public class IntegerConstant extends NumberConstant {

    private final int value;

    @Override
    protected Type getType() {
        return Type.INTEGER;
    }
}
