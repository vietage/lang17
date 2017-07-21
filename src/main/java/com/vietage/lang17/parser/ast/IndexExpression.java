package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     '[' { WHITESPACE } EXPRESSION ']'
 * </pre>
 */
public class IndexExpression extends CompositeElement {

    private final Token leftSquareBracket = new Token("[");
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final Expression expression = new Expression();
    private final Token rightSquareBracket = new Token("]");

    @Override
    protected Element[] getElements() {
        return new Element[]{
                leftSquareBracket,
                optionalWhitespace,
                expression,
                rightSquareBracket
        };
    }
}
