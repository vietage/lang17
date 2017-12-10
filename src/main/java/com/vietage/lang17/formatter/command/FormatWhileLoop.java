package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.statement.WhileLoop;

import java.util.Deque;

public class FormatWhileLoop extends FormatCommand {

    private final WhileLoop whileLoop;

    public FormatWhileLoop(int indent, WhileLoop whileLoop) {
        super(indent);
        this.whileLoop = whileLoop;
    }

    @Override
    public void format(IndentPrintStream out, Deque<FormatCommand> commands) {

    }
}
