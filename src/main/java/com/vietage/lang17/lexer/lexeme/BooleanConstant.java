package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     'true' | 'false'
 * </pre>
 */
public class BooleanConstant extends Choice implements ConstantElement {

    private static final boolean[] BOOLEANS = new boolean[]{
            false,
            true
    };

    @Override
    protected Element[] getElements() {
        return new Element[]{
                new Token("false"),
                new Token("true")
        };
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public boolean getResult() {
        return BOOLEANS[getCurrentElement()];
    }
}
