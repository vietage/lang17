package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     '+' | '-'
 * </pre>
 */
public class AddKeyword extends Choice {

    private final Token plusKeyword = new Token("+");
    private final Token minusKeyword = new Token("-");

    @Override
    protected Element[] getElements() {
        return new Element[]{
                plusKeyword,
                minusKeyword
        };
    }
}
