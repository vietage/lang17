package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     '*' | '/' | '%'
 * </pre>
 */
public class MulKeyword extends Choice {

    private final Token multiplyKeyword = new Token("*");
    private final Token divideKeyword = new Token("/");
    private final Token remainderKeyword = new Token("%");

    @Override
    protected Element[] getElements() {
        return new Element[]{
                multiplyKeyword,
                divideKeyword,
                remainderKeyword
        };
    }
}
