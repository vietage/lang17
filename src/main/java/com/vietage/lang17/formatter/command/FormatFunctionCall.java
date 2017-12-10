package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.FunctionCall;

import java.util.Deque;

public class FormatFunctionCall extends FormatCommand {

    private final FunctionCall functionCall;

    public FormatFunctionCall(int indent, FunctionCall functionCall) {
        super(indent);
        this.functionCall = functionCall;
    }

    @Override
    public void format(IndentPrintStream out, Deque<FormatCommand> commands) {
        out.print(functionCall.getName(), indent);
        out.print("(", indent);

        if (!functionCall.getArguments().isEmpty()) {
            commands.push(new InsertText(indent, ")"));
            commands.push(new FormatArguments(indent, functionCall.getArguments()));
        } else {
            out.print(")", indent);
        }
    }
}
