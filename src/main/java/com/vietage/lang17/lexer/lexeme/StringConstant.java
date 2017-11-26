package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     '"' { STR_CHAR } '"'
 * </pre>
 */
public class StringConstant extends CompositeElement
        implements ConstantElement {

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

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public StringToken getStringToken() {
        return stringToken;
    }
}
