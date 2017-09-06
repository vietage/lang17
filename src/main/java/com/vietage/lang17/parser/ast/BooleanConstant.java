package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     'true' | 'false'
 * </pre>
 */
public class BooleanConstant extends Choice {

    @Override
    protected Element[] getElements() {
        return new Element[]{
                new Token("true"),
                new Token("false")
        };
    }
}
