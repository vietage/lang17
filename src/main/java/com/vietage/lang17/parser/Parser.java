package com.vietage.lang17.parser;

import com.vietage.lang17.lexer.lexeme.Root;
import com.vietage.lang17.parser.ast.Program;

import java.util.ArrayDeque;
import java.util.Queue;

public class Parser {

    private final Queue<ParseCommand> commandQueue = new ArrayDeque<>();

    public Program parse(Root root) {
        Program program = new Program();


    }
}
