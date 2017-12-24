package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.ArrayAllocation;

import java.util.Queue;

public class FormatArrayAllocation extends FormatCommand {

    public FormatArrayAllocation(int indent, ArrayAllocation arrayAllocation) {
        super(indent);
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {

    }
}
