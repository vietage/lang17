package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     ',' { WHITESPACE } EXPRESSION { WHITESPACE }
 * </pre>
 */
public class RestExpressions extends CompositeElement {

    private final Token comma = new Token(",");
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final Expression expression = new Expression();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                comma,
                optionalWhitespace,
                expression,
                optionalWhitespace
        };
    }
}
