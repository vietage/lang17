package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     '+' | '-'
 * </pre>
 */
public class AddKeyword extends Choice {

    @Override
    protected Element[] getElements() {
        return new Element[]{
                new Token("+"),
                new Token("-")
        };
    }
}
