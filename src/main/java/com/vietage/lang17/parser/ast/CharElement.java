package com.vietage.lang17.parser.ast;

import com.vietage.lang17.parser.Context;
import com.vietage.lang17.parser.SourceReader;

/**
 * EBNF:
 * <pre>
 *     '_' | '-' | ? unicode letter ?
 * </pre>
 */
public class CharElement extends Element {

    private final char[] cbuf = new char[1];

    @Override
    public boolean parse(Context context) {
        context.exit();

        int result = context.getSourceReader().read(cbuf);

        if (result == SourceReader.EOF) {
            return false;
        }

        switch (cbuf[0]) {
            case '_':
            case '-':
                return true;
            default:
                return Character.isLetter(cbuf[0]);
        }
    }

    public char getCharacter() {
        return cbuf[0];
    }
}
