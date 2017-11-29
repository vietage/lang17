package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     'break' | 'continue'
 * </pre>
 */
public class LoopOp extends Choice implements StatementChoiceLexeme {

    private Token breakToken;
    private Token continueToken;

    @Override
    protected Lexeme[] getLexemes() {
        breakToken = new Token("break");
        continueToken = new Token("continue");

        return new Lexeme[]{
                breakToken,
                continueToken
        };
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public boolean isBreak() {
        return getLexeme() == breakToken;
    }

    public boolean isContinue() {
        return getLexeme() == continueToken;
    }
}
