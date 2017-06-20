package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     'break' | 'continue'
 * </pre>
 */
public class LoopOp extends Choice {

    private final Token breakKeyword = new Token("break");
    private final Token continueKeyword = new Token("continue");

    @Override
    protected Element[] getElements() {
        return new Element[]{
                breakKeyword,
                continueKeyword
        };
    }
}
