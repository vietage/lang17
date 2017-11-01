package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     'int' | 'float' | 'boolean' | 'string'
 * </pre>
 */
public class BasicType extends Choice {

    private Token intToken;
    private Token floatToken;
    private Token booleanToken;
    private Token stringToken;

    @Override
    protected Element[] getElements() {
        intToken = new Token("int");
        floatToken = new Token("float");
        booleanToken = new Token("boolean");
        stringToken = new Token("string");

        return new Element[]{
                intToken,
                floatToken,
                booleanToken,
                stringToken
        };
    }

    public Token getIntToken() {
        return intToken;
    }

    public Token getFloatToken() {
        return floatToken;
    }

    public Token getBooleanToken() {
        return booleanToken;
    }

    public Token getStringToken() {
        return stringToken;
    }
}
