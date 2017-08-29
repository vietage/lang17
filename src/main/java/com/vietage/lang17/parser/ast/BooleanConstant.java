package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     'true' | 'false'
 * </pre>
 */
public class BooleanConstant extends Choice {

    private final Token trueToken = new Token("true");
    private final Token falseToken = new Token("false");

    @Override
    protected Element[] getElements() {
        return new Element[]{
                trueToken,
                falseToken
        };
    }
}
