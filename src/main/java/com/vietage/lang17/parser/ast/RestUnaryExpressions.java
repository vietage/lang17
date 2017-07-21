package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     MUL_OP { WHITESPACE } UNARY_EXPR { WHITESPACE }
 * </pre>
 */
public class RestUnaryExpressions extends CompositeElement {

    private final MulKeyword mulKeyword = new MulKeyword();
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final UnaryExpression unaryExpression = new UnaryExpression();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                mulKeyword,
                optionalWhitespace,
                unaryExpression,
                optionalWhitespace
        };
    }
}
