package com.vietage.lang17.parser.lexeme;

/**
 * EBNF:
 * <pre>
 *     '==' | '!='
 * </pre>
 */
public class EqualOp extends Choice {

    @Override
    protected Element[] getElements() {
        return new Element[]{
                new Token("=="),
                new Token("!=")
        };
    }
}