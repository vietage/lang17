package com.vietage.lang17.lexer.lexeme;

import com.vietage.lang17.lexer.Context;

public abstract class CompositeLexeme extends BaseLexeme {

    private static final int FIRST_LEXEME = 0;

    private Lexeme[] lexemes;
    private int currentLexeme = FIRST_LEXEME;

    protected abstract Lexeme[] getLexemes();

    @Override
    public boolean parse(Context context) {
        if (currentLexeme == FIRST_LEXEME) {
            lexemes = getLexemes();
        } else if (!context.getLastResult()) {
            context.exit();
            return false;
        } else if (currentLexeme >= lexemes.length) {
            context.exit();
            return true;
        }
        context.enter(lexemes[currentLexeme++]);
        return true;
    }
}
