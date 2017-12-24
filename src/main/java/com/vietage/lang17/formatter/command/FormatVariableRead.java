package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.VariableRead;

import java.util.Queue;

public class FormatVariableRead extends FormatCommand {

    public FormatVariableRead(int indent, VariableRead variableRead) {
        super(indent);
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {

    }
}
