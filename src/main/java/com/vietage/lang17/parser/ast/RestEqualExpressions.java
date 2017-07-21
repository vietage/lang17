package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     '&&' { WHITESPACE } EQUAL_EXPR { WHITESPACE }
 * </pre>
 */
public class RestEqualExpressions extends CompositeElement {

    private final Token andKeyword = new Token("&&");
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final EqualExpression equalExpression = new EqualExpression();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                andKeyword,
                optionalWhitespace,
                equalExpression,
                optionalWhitespace
        };
    }
}
