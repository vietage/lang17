package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.FunctionCall;

import java.util.Queue;

public class FormatFunctionCall extends FormatCommand {

    private final FunctionCall functionCall;

    public FormatFunctionCall(int indent, FunctionCall functionCall) {
        super(indent);
        this.functionCall = functionCall;
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {
        out.print(functionCall.getName(), indent);
        out.print("(", indent);

        if (!functionCall.getArguments().isEmpty()) {
            commandQueue.add(new FormatArguments(indent, functionCall.getArguments()));
            commandQueue.add(new InsertText(indent, ")"));
        } else {
            out.print(")", indent);
        }
    }
}
