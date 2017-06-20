package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     EQUAL_EXPR { WHITESPACE } { REST_EQUAL_EXPRS }
 * </pre>
 */
public class AndExpression extends CompositeElement {

    private final EqualExpression equalExpression = new EqualExpression();
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final ZeroOrMore<RestEqualExpressions> restEqualExpressions = new ZeroOrMore<>(RestEqualExpressions::new);

    @Override
    protected Element[] getElements() {
        return new Element[]{
                equalExpression,
                optionalWhitespace,
                restEqualExpressions
        };
    }
}
