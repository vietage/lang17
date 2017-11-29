package com.vietage.lang17.parser.command;

import com.vietage.lang17.lexer.lexeme.FunctionAndWhitespace;
import com.vietage.lang17.lexer.lexeme.Root;
import com.vietage.lang17.parser.ast.Program;

import java.util.Queue;

public class ParseProgram extends ParseCommand<Root, Program> {

    public ParseProgram(Root lexeme, ResultConsumer<Program> action) {
        super(lexeme, action);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {
        Program program = new Program();

        for (FunctionAndWhitespace func : lexeme.getFunctions().getFunctions()) {
            commandQueue.add(new ParseFunction(func, function -> {
                program.getFunctions().put(function.getName(), function);
            }));
        }

        resultConsumer.consume(program);
    }
}
