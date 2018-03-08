package com.vietage.lang17.interpreter;

import com.vietage.lang17.interpreter.state.Invoke;
import com.vietage.lang17.parser.ast.Program;

public class Interpreter {

    private static final String MAIN_FUNCTION = "main";

    public void interpret(Program program) {
        Runtime runtime = new Runtime(program.getFunctions());

        runtime.enterState(new Invoke(runtime.getGlobalContext(), MAIN_FUNCTION));

        while (runtime.hasState()) {
            runtime.getState().run(runtime);
        }
    }
}
