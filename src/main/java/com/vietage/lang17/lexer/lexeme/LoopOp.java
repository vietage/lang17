package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     'break' | 'continue'
 * </pre>
 */
public class LoopOp extends Choice implements Statement {

    private Token breakToken;
    private Token continueToken;

    @Override
    protected Element[] getElements() {
        breakToken = new Token("break");
        continueToken = new Token("continue");

        return new Element[]{
                breakToken,
                continueToken
        };
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public boolean isBreak() {
        return getElement() == breakToken;
    }

    public boolean isContinue() {
        return getElement() == continueToken;
    }
}
