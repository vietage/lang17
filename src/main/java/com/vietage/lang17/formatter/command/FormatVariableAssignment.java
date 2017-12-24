package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.statement.VariableAssignment;

import java.util.Queue;

public class FormatVariableAssignment extends FormatCommand {

    private final VariableAssignment variableAssignment;

    public FormatVariableAssignment(int indent, VariableAssignment variableAssignment) {
        super(indent);
        this.variableAssignment = variableAssignment;
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {
        out.print(variableAssignment.getName(), indent);

        if (variableAssignment.getIndexExpression() != null) {
            out.print("[", indent);

            commandQueue.add(new FormatExpression(indent, variableAssignment.getIndexExpression()));
            commandQueue.add(new InsertText(indent, "] = "));
        } else {
            out.print(" = ", indent);
        }

        commandQueue.add(new FormatExpression(indent, variableAssignment.getExpression()));
        commandQueue.add(new InsertLineFeed(indent));
    }
}
