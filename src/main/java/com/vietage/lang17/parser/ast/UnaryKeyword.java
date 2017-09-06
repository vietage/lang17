package com.vietage.lang17.parser.ast;

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
