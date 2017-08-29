package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     'int' | 'float' | 'boolean' | 'string'
 * </pre>
 */
public class BasicType extends Choice {

    private final Token intToken = new Token("int");
    private final Token floatToken = new Token("float");
    private final Token booleanToken = new Token("boolean");
    private final Token stringToken = new Token("string");

    @Override
    protected Element[] getElements() {
        return new Element[]{
                intToken,
                floatToken,
                booleanToken,
                stringToken
        };
    }
}
