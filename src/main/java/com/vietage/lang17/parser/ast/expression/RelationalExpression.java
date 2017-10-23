package com.vietage.lang17.parser.ast.expression;

public class RelationalExpression extends Expression {
    private final RelationalOperator operator;
    private final Expression leftExpression;
    private final Expression rightExpression;
}
