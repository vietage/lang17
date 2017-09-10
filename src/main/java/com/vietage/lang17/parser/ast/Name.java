package com.vietage.lang17.parser.ast;

import com.vietage.lang17.parser.Context;
import com.vietage.lang17.parser.Position;
import com.vietage.lang17.parser.SourceReader;

/**
 * EBNF:
 * <pre>
 *     CHAR { ALPHA_NUM }
 *     CHAR = '_' | ? letter ?
 *     ALPHA_NUM = CHAR | ? digit ?
 * </pre>
 */
public class Name extends Element {

    private String result;

    @Override
    public boolean parse(Context context) {
        context.exit();

        SourceReader sr = context.getSourceReader();
        StringBuilder sb = new StringBuilder();
        char[] cbuf = new char[1];

        if (sr.read(cbuf) && isLetterOrUnderscore(cbuf[0])) {
            sb.append(cbuf[0]);
        } else {
            return false;
        }

        Position lastPosition = sr.getPosition();

        while (sr.read(cbuf)) {
            if (isLetterOrDigitOrUnderscore(cbuf[0])) {
                sb.append(cbuf[0]);
                lastPosition = sr.getPosition();
            } else {
                sr.reset(lastPosition);
                break;
            }
        }

        this.result = sb.toString();

        return true;
    }

    private boolean isLetterOrDigitOrUnderscore(char c) {
        return c == '_' || Character.isLetterOrDigit(c);
    }

    private boolean isLetterOrUnderscore(char c) {
        return c == '_' || Character.isLetter(c);
    }

    public String getResult() {
        return this.result;
    }
}
