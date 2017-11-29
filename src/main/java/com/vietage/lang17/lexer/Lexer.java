package com.vietage.lang17.lexer;

import com.vietage.lang17.lexer.lexeme.Lexeme;
import com.vietage.lang17.lexer.lexeme.Root;

import java.io.IOException;

public class Lexer {

    public Root read(String file) throws IOException {
        SourceReader sourceReader = new SourceReader(file);
        Context context = new Context(sourceReader);
        ErrorChain errorChain = new ErrorChain();

        Root root = new Root();
        context.enter(root);

        Lexeme lexeme;
        while ((lexeme = context.current()) != null) {
            context.setLastResult(lexeme.parse(context));
            if (!context.getLastResult()) {
                sourceReader.reset(lexeme.getStartPosition());
                errorChain.add(lexeme);
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
