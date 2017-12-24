package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.Function;
import com.vietage.lang17.parser.ast.Program;

import java.util.Queue;

public class FormatProgram extends FormatCommand {

    private final Program program;

    public FormatProgram(int indent, Program program) {
        super(indent);
        this.program = program;
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {
        boolean first = true;

        for (Function function : program.getFunctions().values()) {
            if (!first) {
                commandQueue.add(new InsertLineFeed(indent));
            }
            first = false;

            commandQueue.add(new FormatFunction(indent, function));
        }
    }
}
