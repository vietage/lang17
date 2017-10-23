package com.vietage.lang17.parser.ast.expression;

import com.vietage.lang17.parser.ast.Type;

public class StringConstant extends ConstantExpression {

    private final String value;

    @Override
    protected Type getType() {
        return Type.STRING;
    }
}
