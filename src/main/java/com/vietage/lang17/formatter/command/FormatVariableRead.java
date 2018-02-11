package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.VariableRead;

import java.util.Queue;

public class FormatVariableRead extends FormatCommand {

    private final VariableRead variableRead;

    public FormatVariableRead(int indent, VariableRead variableRead) {
        super(indent);
        this.variableRead = variableRead;
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {
        out.print(variableRead.getName(), indent);
    }
}
