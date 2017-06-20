package com.vietage.lang17.parser.ast;

import com.vietage.lang17.parser.Context;

/**
 * EBNF:
 * <pre>
 *     { WHITESPACE }
 * </pre>
 */
public class OptionalWhitespace extends Element {

    private final Whitespace whitespace = new Whitespace();

    @Override
    public boolean parse(Context context) {
        if (context.getLastResult()) {
            context.enter(whitespace);
        } else {
            context.exit();
        }
        return true;
    }
}
