package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.Expression;
import com.vietage.lang17.parser.ast.expression.OperatorPrecedence;

import java.util.Queue;

public abstract class FormatOperatorExpression extends FormatCommand {

    protected final OperatorPrecedence parentOperatorPrecedence;

    protected abstract Expression getExpression();

    protected abstract void addFormatCommands(Queue<FormatCommand> commandQueue);

    protected FormatOperatorExpression(int indent, OperatorPrecedence parentOperatorPrecedence) {
        super(indent);
        this.parentOperatorPrecedence = parentOperatorPrecedence;
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {
        if (getExpression().getOperatorPrecedence().less(parentOperatorPrecedence)) {
            commandQueue.add(new InsertText(indent, "("));
            addFormatCommands(commandQueue);
            commandQueue.add(new InsertText(indent, ")"));
        } else {
            addFormatCommands(commandQueue);
        }
    }
}
