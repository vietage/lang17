package com.vietage.lang17.parser.ast;

import com.vietage.lang17.parser.Context;
import com.vietage.lang17.parser.Position;
import com.vietage.lang17.parser.SourceReader;

/**
 * EBNF:
 * <pre>
 *     DIGIT { DIGIT }
 * </pre>
 */
public class IntegerPart extends Element {

    private Long result;

    @Override
    public boolean parse(Context context) {
        context.exit();

        SourceReader sourceReader = context.getSourceReader();
        char[] cbuf = new char[1];
        StringBuilder sb = new StringBuilder();
        Position lastPosition = sourceReader.getPosition();

        while (sourceReader.read(cbuf)) {
            if (Character.isDigit(cbuf[0])) {
                sb.append(cbuf[0]);
                lastPosition = sourceReader.getPosition();
            } else {
                sourceReader.reset(lastPosition);
                break;
            }
        }

        if (sb.length() > 0) {
            this.result = Long.parseUnsignedLong(sb.toString());
            return true;
        }

        return false;
    }

    public Long getResult() {
        return this.result;
    }
}
