package com.vietage.lang17.lexer.lexeme;

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
