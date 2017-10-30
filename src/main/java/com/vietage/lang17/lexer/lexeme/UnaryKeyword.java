package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     '!' | '-'
 * </pre>
 */
public class UnaryKeyword extends Choice {

    @Override
    protected Element[] getElements() {
        return new Element[]{
                new Token("!"),
                new Token("-")
        };
    }
}
