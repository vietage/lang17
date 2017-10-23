package com.vietage.lang17.parser;

import com.vietage.lang17.parser.lexeme.Element;
import com.vietage.lang17.parser.lexeme.Program;

import java.io.IOException;

public class Lang17Parser {

    public Program parse(String file) throws IOException {
        SourceReader sourceReader = new SourceReader(file);
        Context context = new Context(sourceReader);
        ErrorChain errorChain = new ErrorChain();

        Program program = new Program();
        context.enter(program);

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
            throw new ParseException(errorChain.formatErrorMessage(sourceReader));
        }

        return program;
    }
}
