package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.Expression;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class FormatArguments extends FormatCommand {

    private final List<Expression> arguments;

    public FormatArguments(int indent, List<Expression> arguments) {
        super(indent);
        this.arguments = arguments;
    }

    @Override
    public void format(IndentPrintStream out, Deque<FormatCommand> commands) {
        Iterator<Expression> it = getReverseIterator();

        boolean first = true;

        while (it.hasNext()) {
            if (!first) {
                commands.push(new InsertCommaSeparator(indent));
            }
            first = false;

            Expression expression = it.next();
            commands.push(new FormatExpression(indent, expression));
        }
    }

    public Iterator<Expression> getReverseIterator() {
        return new ArrayDeque<>(arguments).descendingIterator();
    }
}
