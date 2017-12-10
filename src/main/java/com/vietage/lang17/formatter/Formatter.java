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
        Deque<FormatCommand> commands = new ArrayDeque<>();

        commands.push(new FormatProgram(0, program));

        while (!commands.isEmpty()) {
            commands.pop().format(indentPrintStream, commands);
        }
    }
}
