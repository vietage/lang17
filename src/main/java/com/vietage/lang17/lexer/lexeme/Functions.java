package com.vietage.lang17.lexer.lexeme;

import com.vietage.lang17.lexer.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Special parser element which parses functions to the end of file.
 * <p>
 * EBNF:
 * <pre>
 *     FUNCTION { WHITESPACE } { FUNCTION { WHITESPACE } }
 * </pre>
 */
public class Functions extends BaseLexeme {

    private final List<FunctionAndWhitespace> functions = new ArrayList<>();
    private FunctionAndWhitespace currentFunction;

    @Override
    public boolean parse(Context context) {
        if (!context.getLastResult()) {
            context.exit();
            return false;
        }

        if (currentFunction == null) {
            currentFunction = new FunctionAndWhitespace();
            context.enter(currentFunction);
        } else {
            functions.add(currentFunction);
            if (context.getSourceReader().isEndOfFile()) {
                context.exit();
            } else {
                currentFunction = new FunctionAndWhitespace();
                context.enter(currentFunction);
            }
        }

        return true;
    }

    public List<FunctionAndWhitespace> getFunctions() {
        return functions;
    }
}
