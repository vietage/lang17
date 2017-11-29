package com.vietage.lang17.lexer.lexeme;

import com.vietage.lang17.lexer.Context;

public class ZeroOrOne<T extends Lexeme> extends BaseLexeme {

    private final T lexeme;
    private Boolean result;

    public ZeroOrOne(T lexeme) {
        this.lexeme = lexeme;
    }

    @Override
    public boolean parse(Context context) {
        if (result == null) {
            result = true;
            context.enter(lexeme);
        } else {
            result = context.getLastResult();
            context.exit();
        }

        return true;
    }

    public Boolean getResult() {
        return result;
    }

    public T getLexeme() {
        return lexeme;
    }
}
