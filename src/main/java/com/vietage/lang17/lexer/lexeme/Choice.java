package com.vietage.lang17.lexer.lexeme;

import com.vietage.lang17.lexer.Context;

public abstract class Choice extends BaseLexeme {

    private static final int INIT_STATE = -1;

    private Lexeme[] lexemes;
    private int currentLexeme = INIT_STATE;

    protected abstract Lexeme[] getLexemes();

    @Override
    public boolean parse(Context context) {
        if (currentLexeme == INIT_STATE) {
            lexemes = getLexemes();
        } else if (context.getLastResult()) {
            context.exit();
            return true;
        }
        currentLexeme++;
        if (currentLexeme < lexemes.length) {
            context.enter(lexemes[currentLexeme]);
            return true;
        } else {
            context.exit();
            return false;
        }
    }

    protected int getCurrentLexeme() {
        return currentLexeme;
    }
}
