package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.ArrayAllocation;

import java.util.Queue;

public class FormatArrayAllocation extends FormatCommand {

    private final ArrayAllocation arrayAllocation;

    public FormatArrayAllocation(int indent, ArrayAllocation arrayAllocation) {
        super(indent);
        this.arrayAllocation = arrayAllocation;
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {
        commandQueue.add(new FormatType(indent, arrayAllocation.getType()));
        commandQueue.add(new InsertText(indent, "["));
        commandQueue.add(new FormatExpression(indent, arrayAllocation.getSizeExpression()));
        commandQueue.add(new InsertText(indent, "]"));
    }
}
