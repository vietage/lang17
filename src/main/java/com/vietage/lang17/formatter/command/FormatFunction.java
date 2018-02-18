package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.Argument;
import com.vietage.lang17.parser.ast.Function;

import java.util.Queue;

public class FormatFunction extends FormatCommand {

    private final Function function;

    public FormatFunction(int indent, Function function) {
        super(indent);
        this.function = function;
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {
        commandQueue.add(new FormatType(indent, function.getReturnType()));
        commandQueue.add(new InsertText(indent, " " + function.getName() + "("));

        formatArguments(commandQueue);

        commandQueue.add(new InsertText(indent, ")"));
        commandQueue.add(new InsertLineFeed(indent));
        commandQueue.add(new InsertText(indent, "{"));
        commandQueue.add(new InsertLineFeed(indent));
        commandQueue.add(new FormatStatements(indent + 4, function.getStatements()));
        commandQueue.add(new InsertLineFeed(indent));
        commandQueue.add(new InsertText(indent, "}"));
        commandQueue.add(new InsertLineFeed(indent));
    }

    private void formatArguments(Queue<FormatCommand> commandQueue) {
        boolean first = true;

        for (Argument argument : function.getArguments()) {
            if (!first) {
                commandQueue.add(new InsertText(indent, ", "));
            }
            first = false;

            commandQueue.add(new FormatType(indent, argument.getType()));
            commandQueue.add(new InsertText(indent, " " + argument.getName()));
        }
    }
}
