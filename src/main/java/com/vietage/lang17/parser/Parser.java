package com.vietage.lang17.parser;

import com.vietage.lang17.lexer.lexeme.Root;
import com.vietage.lang17.parser.ast.Program;

import java.util.ArrayDeque;
import java.util.Queue;

public class Parser {

    private final Queue<ParseCommand> commandQueue = new ArrayDeque<>();
    private Program program;

    public Program parse(Root root) {
        commandQueue.add(new ParseProgram(root, program -> this.program = program));

        do {
            ParseCommand parseAction = commandQueue.remove();
            parseAction.parse(commandQueue);
        } while (!commandQueue.isEmpty());

        return program;
    }
}
