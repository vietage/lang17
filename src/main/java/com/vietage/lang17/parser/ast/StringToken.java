package com.vietage.lang17.parser.ast;

import com.vietage.lang17.parser.Context;
import com.vietage.lang17.parser.Position;
import com.vietage.lang17.parser.SourceReader;

/**
 * EBNF:
 * <pre>
 *     ? character sequence ?
 * </pre>
 */
public class StringToken extends Element {

    private String result;

    @Override
    public boolean parse(Context context) {
        context.exit();

        SourceReader sr = context.getSourceReader();
        StringBuilder sb = new StringBuilder();
        char[] cbuf = new char[1];
        Position lastPosition = sr.getPosition();

        boolean escape = false;

        while (sr.read(cbuf)) {
            switch (cbuf[0]) {
                case '\\':
                    if (escape) {
                        escape = false;
                        sb.append('\\');
                    } else {
                        escape = true;
                    }
                    break;
                case '"':
                    if (escape) {
                        escape = false;
                        sb.append(cbuf[0]);
                    } else {
                        sr.reset(lastPosition);
                        this.result = sb.toString();
                        return true;
                    }
                    break;
                default:
                    sb.append(cbuf[0]);
            }
            lastPosition = sr.getPosition();
        }

        return false;
    }

    public String getResult() {
        return this.result;
    }
}
