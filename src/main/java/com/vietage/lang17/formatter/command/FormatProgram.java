package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.Function;
import com.vietage.lang17.parser.ast.Program;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class FormatProgram extends FormatCommand {

    private final Program program;

    public FormatProgram(int indent, Program program) {
        super(indent);
        this.program = program;
    }

    @Override
    public void format(IndentPrintStream out, Deque<FormatCommand> commands) {
        // reverse the order of functions
        Iterator<Function> it = getReverseIterator();

        boolean first = true;

        // push format commands in reverse order to the command stack
        while (it.hasNext()) {
            if (!first) {
                commands.push(new InsertEmptyLine(indent));
            }
            first = false;

            Function function = it.next();
            commands.push(new FormatFunction(indent, function));
        }
    }

    private Iterator<Function> getReverseIterator() {
        return new ArrayDeque<>(program.getFunctions().values()).descendingIterator();
    }
}
