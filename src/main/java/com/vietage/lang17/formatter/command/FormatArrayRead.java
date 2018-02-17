package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.ArrayRead;

import java.util.Queue;

public class FormatArrayRead extends FormatCommand {

    private final ArrayRead arrayRead;

    public FormatArrayRead(int indent, ArrayRead arrayRead) {
        super(indent);
        this.arrayRead = arrayRead;
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {
        commandQueue.add(new InsertText(indent, arrayRead.getName() + "["));
        commandQueue.add(new FormatExpression(indent, arrayRead.getIndexExpression()));
        commandQueue.add(new InsertText(indent, "]"));
    }
}
