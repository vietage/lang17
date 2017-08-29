package com.vietage.lang17.parser.ast;

import com.vietage.lang17.parser.Context;
import com.vietage.lang17.parser.SourceReader;

/**
 * EBNF:
 * <pre>
 *     CHAR | DIGIT
 * </pre>
 */
public class AlphaNumeric extends Element {

    private final char[] cbuf = new char[1];

    @Override
    public boolean parse(Context context) {
        return context.getSourceReader().read(cbuf) != SourceReader.EOF &&
                Character.isLetterOrDigit(cbuf[0]);
    }

    public char getCharacter() {
        return cbuf[0];
    }
}
