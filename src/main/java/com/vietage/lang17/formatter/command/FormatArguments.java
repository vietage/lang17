package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.Expression;

import java.util.Deque;
import java.util.List;

public class FormatArguments extends FormatCommand {

    private final List<Expression> arguments;

    public FormatArguments(int indent, List<Expression> arguments) {
        super(indent);
        this.arguments = arguments;
    }

    @Override
    public void format(IndentPrintStream out, Deque<FormatCommand> commandQueue) {
        boolean first = true;

        for (Expression argument : arguments) {
            if (!first) {
                commandQueue.add(new InsertCommaSeparator(indent));
            }
            first = false;

            commandQueue.add(new FormatExpression(indent, argument));
        }
    }
}
