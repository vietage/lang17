package com.vietage.lang17.interpreter;

import com.vietage.lang17.parser.ast.Function;
import com.vietage.lang17.parser.ast.Program;

import java.util.ArrayDeque;
import java.util.Deque;

public class Interpreter {

    private static final String MAIN_FUNCTION = "main";

    public void interpret(Program program) {
        Function main = program.getFunctions().get(MAIN_FUNCTION);

        if (main == null) {
            throw new InterpreterException("`" + MAIN_FUNCTION + "` function not found");
        }

        Deque<Command> commands = new ArrayDeque<>();

        commands.push(new Invoke(main));

        Command command;
        while ((command = commands.pop()) != null) {
            command.run(commands);
        }
    }
}
