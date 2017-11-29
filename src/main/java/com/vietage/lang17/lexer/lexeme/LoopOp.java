package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     'break' | 'continue'
 * </pre>
 */
public class LoopOp extends Choice implements StatementChoiceLexeme {

    private static final int BREAK_INDEX = 0;
    private static final int CONTINUE_INDEX = 1;

    @Override
    protected Lexeme[] getLexemes() {
        return new Lexeme[]{
                new Token("break"),
                new Token("continue")
        };
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public boolean isBreak() {
        return getCurrentLexeme() == BREAK_INDEX;
    }

    public boolean isContinue() {
        return getCurrentLexeme() == CONTINUE_INDEX;
    }
}
