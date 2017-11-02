package com.vietage.lang17.parser.ast.expression;

import com.vietage.lang17.parser.ast.Type;

public class BooleanConstant extends ConstantExpression {

    private final boolean value;

    @Override
    protected Type getType() {
        return Type.BOOLEAN;
    }
}
