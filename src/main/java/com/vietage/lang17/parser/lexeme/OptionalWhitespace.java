package com.vietage.lang17.parser.lexeme;

import com.vietage.lang17.parser.Context;
import com.vietage.lang17.parser.Position;
import com.vietage.lang17.parser.SourceReader;

/**
 * EBNF:
 * <pre>
 *     { WHITESPACE }
 * </pre>
 */
public class OptionalWhitespace extends Element {

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
