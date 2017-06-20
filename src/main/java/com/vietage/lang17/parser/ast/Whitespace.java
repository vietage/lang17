package com.vietage.lang17.parser.ast;

import com.vietage.lang17.parser.Context;

public class Whitespace extends Element {

    private final char[] cbuf = new char[1];

    @Override
    public boolean parse(Context context) {
        return context.getSourceReader().read(cbuf) != -1 && Character.isWhitespace(cbuf[0]);
    }
}
