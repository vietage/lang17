package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.statement.VariableAssignment;

import java.util.Deque;

public class FormatVariableAssignment extends FormatCommand {

    private final VariableAssignment variableAssignment;

    public FormatVariableAssignment(int indent, VariableAssignment variableAssignment) {
        super(indent);
        this.variableAssignment = variableAssignment;
    }

    @Override
    public void format(IndentPrintStream out, Deque<FormatCommand> commandQueue) {

    }
}
