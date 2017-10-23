package com.vietage.lang17.parser.lexeme;

/**
 * EBNF:
 * <pre>
 *     'break' | 'continue'
 * </pre>
 */
public class LoopOp extends Choice {

    @Override
    protected Element[] getElements() {
        return new Element[]{
                new Token("break"),
                new Token("continue")
        };
    }
}
