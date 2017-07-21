package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     '!' | '-'
 * </pre>
 */
public class UnaryKeyword extends Choice {

    private final Token notKeyword = new Token("!");
    private final Token minusKeyword = new Token("-");

    @Override
    protected Element[] getElements() {
        return new Element[]{
                notKeyword,
                minusKeyword
        };
    }
}
