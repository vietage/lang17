package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.statement.VariableDefinition;

import java.util.Deque;

public class FormatVariableDefinition extends FormatCommand {

    private final VariableDefinition variableDefinition;

    public FormatVariableDefinition(int indent, VariableDefinition variableDefinition) {
        super(indent);
        this.variableDefinition = variableDefinition;
    }

    @Override
    public void format(IndentPrintStream out, Deque<FormatCommand> commands) {

    }
}
