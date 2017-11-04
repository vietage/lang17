package com.vietage.lang17.lexer.lexeme;

import com.vietage.lang17.lexer.Context;
import com.vietage.lang17.lexer.Position;
import com.vietage.lang17.lexer.SourceReader;

/**
 * EBNF:
 * <pre>
 *     { WHITESPACE }
 * </pre>
 */
public class OptionalWhitespace extends BaseElement {

    @Override
    public boolean parse(Context context) {
        context.exit();

        SourceReader sr = context.getSourceReader();
        char[] cbuf = new char[1];
        Position lastPosition = sr.getPosition();

        while (sr.read(cbuf)) {
            if (!Character.isWhitespace(cbuf[0])) {
                sr.reset(lastPosition);
                break;
            }
            lastPosition = sr.getPosition();
        }

        return true;
    }
}
