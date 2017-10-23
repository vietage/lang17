package com.vietage.lang17.parser.lexeme;

/**
 * EBNF:
 * <pre>
 *     '&&' { WHITESPACE } EQUAL_EXPR { WHITESPACE }
 * </pre>
 */
public class RestEqualExpressions extends CompositeElement {

    private EqualExpression equalExpression;

    @Override
    protected Element[] getElements() {
        equalExpression = new EqualExpression();

        return new Element[]{
                new Token("&&"),
                new OptionalWhitespace(),
                equalExpression,
                new OptionalWhitespace()
        };
    }

    public EqualExpression getEqualExpression() {
        return equalExpression;
    }
}
