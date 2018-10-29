package com.vietage.lang17.parser;

import com.vietage.lang17.lexer.lexeme.Root;
import com.vietage.lang17.parser.ast.Program;
import com.vietage.lang17.parser.command.ParseCommand;
import com.vietage.lang17.parser.command.ParseProgram;

import java.util.ArrayDeque;
import java.util.Deque;

public class Parser {

    private Program program;

    public Program parse(Root root) {
        Deque<ParseCommand> commandQueue = new ArrayDeque<>();
        Deque<ParseCommand> commandStack = new ArrayDeque<>();

        commandStack.push(
                new ParseProgram(
                        root,
                        this::setProgram
                )
        );

        while (!commandStack.isEmpty()) {
            commandStack.pop().parse(commandQueue);

            while (!commandQueue.isEmpty()) {
                commandStack.push(commandQueue.removeLast());
            }
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
