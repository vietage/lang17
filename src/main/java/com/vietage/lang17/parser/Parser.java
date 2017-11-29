package com.vietage.lang17.parser;

import com.vietage.lang17.lexer.lexeme.Root;
import com.vietage.lang17.parser.ast.Program;
import com.vietage.lang17.parser.command.ParseCommand;
import com.vietage.lang17.parser.command.ParseProgram;

import java.util.ArrayDeque;
import java.util.Queue;

public class Parser {

    private final Queue<ParseCommand> commandQueue = new ArrayDeque<>();
    private Program program;

    public Program parse(Root root) {
        commandQueue.add(
                new ParseProgram(
                        root,
                        this::setProgram
                )
        );

        while (!commandQueue.isEmpty()) {
            ParseCommand parseCommand = commandQueue.remove();
            parseCommand.parse(commandQueue);
        }

        return program;
    }

    public Program getProgram() {
        return program;
    }

    private void setProgram(Program program) {
        this.program = program;
    }
}
