package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     UNARY_EXPR { WHITESPACE } { REST_UNARY_EXPRS }
 * </pre>
 */
public class MulExpression extends CompositeElement {

    private final UnaryExpression unaryExpression = new UnaryExpression();
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final ZeroOrMore<RestUnaryExpressions> restUnaryExpressions = new ZeroOrMore<>(RestUnaryExpressions::new);

    @Override
    protected Element[] getElements() {
        return new Element[]{
                unaryExpression,
                optionalWhitespace,
                restUnaryExpressions
        };
    }
}
