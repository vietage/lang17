package com.vietage.lang17.parser.ast;

import com.vietage.lang17.parser.Context;

import java.util.Arrays;

public class Token extends Element {

    private final char[] token;
    private final char[] cbuf;

    public Token(String tokenStr) {
        this.token = tokenStr.toCharArray();
        this.cbuf = new char[token.length];
    }

    @Override
    public boolean parse(Context context) {
        return context.getSourceReader().read(cbuf) != -1 && Arrays.equals(token, cbuf);
    }
}
