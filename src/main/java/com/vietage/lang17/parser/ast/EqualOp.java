package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     '==' | '!='
 * </pre>
 */
public class EqualOp extends Choice {

    private final Token equalKeyword = new Token("==");
    private final Token notEqualKeyword = new Token("!=");

    @Override
    protected Element[] getElements() {
        return new Element[]{
                equalKeyword,
                notEqualKeyword
        };
    }
}
