package com.vietage.lang17.parser.ast;

import com.vietage.lang17.parser.Context;
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

        while (sr.read(cbuf) != SourceReader.EOF) {
            if (!Character.isWhitespace(cbuf[0])) {
                sr.reset(sr.getPosition() - 1);
                break;
            }
        }

        return true;
    }
}
