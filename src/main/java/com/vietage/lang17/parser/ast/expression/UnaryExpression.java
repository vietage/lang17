package com.vietage.lang17.parser.ast.expression;

public class UnaryExpression extends Expression {
    private final UnaryOperator operator;
    private final Expression leftExpression;
    private final Expression rightExpression;
}
