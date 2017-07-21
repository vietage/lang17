package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     MUL_EXPR { WHITESPACE } { REST_MUL_EXPRS }
 * </pre>
 */
public class AddExpression extends CompositeElement {

    private final MulExpression mulExpression = new MulExpression();
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final ZeroOrMore<RestMulExpressions> restMulExpressions = new ZeroOrMore<>(RestMulExpressions::new);

    @Override
    protected Element[] getElements() {
        return new Element[]{
                mulExpression,
                optionalWhitespace,
                restMulExpressions
        };
    }
}
