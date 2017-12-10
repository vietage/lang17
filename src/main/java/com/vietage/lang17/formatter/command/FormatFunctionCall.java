package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.FunctionCall;

import java.util.Deque;

public class FormatFunctionCall extends FormatCommand {

    private final FunctionCall functionCall;
    private boolean firstTime = true;

    public FormatFunctionCall(int indent, FunctionCall functionCall) {
        super(indent);
        this.functionCall = functionCall;
    }

    @Override
    public void format(IndentPrintStream out, Deque<FormatCommand> commands) {
        if (firstTime) {
            firstTime = false;
            commands.push(this);

            out.print(functionCall.getName(), indent);
            out.print("(", indent);

            if (!functionCall.getArguments().isEmpty()) {
                commands.push(new FormatArguments(indent, functionCall.getArguments()));
            }
        } else {
            out.print(")", indent);
        }
    }
}
