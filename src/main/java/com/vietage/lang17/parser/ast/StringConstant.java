package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     '"' { STR_CHAR } '"'
 * </pre>
 */
public class StringConstant extends CompositeElement {

    private StringToken stringToken;

    @Override
    protected Element[] getElements() {
        stringToken = new StringToken();

        return new Element[]{
                new Token("\""),
                stringToken,
                new Token("\"")
        };
    }

    public StringToken getStringToken() {
        return stringToken;
    }
}
