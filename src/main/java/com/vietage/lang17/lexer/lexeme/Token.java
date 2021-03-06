package com.vietage.lang17.lexer.lexeme;

import com.vietage.lang17.lexer.Context;

import java.util.Arrays;

public class Token extends BaseLexeme {

    private final char[] token;

    public Token(String tokenStr) {
        this.token = tokenStr.toCharArray();
    }

    @Override
    public boolean parse(Context context) {
        context.exit();

        char[] cbuf = new char[token.length];

        return context.getSourceReader().read(cbuf) && Arrays.equals(token, cbuf);
    }

    @Override
    public String toString() {
        return "Token{" +
                "token=" + String.valueOf(token) +
                '}';
    }
}
