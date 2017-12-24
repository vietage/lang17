package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.ArrayRead;

import java.util.Queue;

public class FormatArrayRead extends FormatCommand {

    public FormatArrayRead(int indent, ArrayRead arrayRead) {
        super(indent);
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {

    }
}
