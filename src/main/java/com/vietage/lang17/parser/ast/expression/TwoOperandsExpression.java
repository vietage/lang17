package com.vietage.lang17.parser.ast.expression;

import com.vietage.lang17.parser.ast.PositionalElement;

public interface TwoOperandsExpression extends Expression, PositionalElement {

    Expression getLeftExpression();

    Expression getRightExpression();
}
