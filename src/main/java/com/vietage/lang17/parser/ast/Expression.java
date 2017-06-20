package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     AND_EXPR { WHITESPACE } { REST_AND_EXPRS }
 * </pre>
 */
public class Expression extends CompositeElement {

    private final AndExpression andExpression = new AndExpression();
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final ZeroOrMore<RestAndExpressions> restAndExpressions = new ZeroOrMore<>(RestAndExpressions::new);

    @Override
    protected Element[] getElements() {
        return new Element[]{
                andExpression,
                optionalWhitespace,
                restAndExpressions
        };
    }
}
