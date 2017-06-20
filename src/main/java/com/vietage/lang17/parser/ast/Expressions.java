package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     EXPRESSION { WHITESPACE } { REST_EXPRESSIONS }
 * </pre>
 */
public class Expressions extends CompositeElement {

    private final Expression expression = new Expression();
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final ZeroOrMore<RestExpressions> restExpressions = new ZeroOrMore<>(RestExpressions::new);

    @Override
    protected Element[] getElements() {
        return new Element[]{
                expression,
                optionalWhitespace,
                restExpressions
        };
    }
}
