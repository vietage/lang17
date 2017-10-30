package com.vietage.lang17.lexer;

import com.vietage.lang17.parser.Context;
import com.vietage.lang17.parser.ErrorChain;
import com.vietage.lang17.parser.SourceReader;
import com.vietage.lang17.lexer.lexeme.Element;
import com.vietage.lang17.lexer.lexeme.Root;

import java.io.IOException;

public class Lexer {

    public Root read(String file) throws IOException {
        SourceReader sourceReader = new SourceReader(file);
        Context context = new Context(sourceReader);
        ErrorChain errorChain = new ErrorChain();

        Root root = new Root();
        context.enter(root);

        Element element;
        while ((element = context.current()) != null) {
            context.setLastResult(element.parse(context));
            if (!context.getLastResult()) {
                sourceReader.reset(element.getStartPosition());
                errorChain.add(element);
            } else {
                errorChain.clear();
            }
        }

        if (!context.getLastResult()) {
            throw new LexerException(errorChain.formatErrorMessage(sourceReader));
        }

        return root;
    }
}
