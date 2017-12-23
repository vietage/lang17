package com.vietage.lang17.formatter;

import com.vietage.lang17.formatter.command.FormatCommand;
import com.vietage.lang17.formatter.command.FormatProgram;
import com.vietage.lang17.parser.ast.Program;

import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.Deque;

public class Formatter {

    public void format(Program program, PrintStream out) {
        IndentPrintStream indentPrintStream = new IndentPrintStream(out);
        Deque<FormatCommand> commandStack = new ArrayDeque<>();
        Deque<FormatCommand> commandQueue = new ArrayDeque<>();

        commandStack.push(new FormatProgram(0, program));

        while (!commandStack.isEmpty()) {
            commandStack.pop().format(indentPrintStream, commandQueue);

            while (!commandQueue.isEmpty()) {
                commandStack.push(commandQueue.removeLast());
            }
        }
    }
}
