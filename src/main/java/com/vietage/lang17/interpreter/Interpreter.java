package com.vietage.lang17.interpreter;

import com.vietage.lang17.interpreter.state.Invoke;
import com.vietage.lang17.parser.ast.Program;
import com.vietage.lang17.parser.ast.expression.FunctionCall;

public class Interpreter {

    private static final String MAIN_FUNCTION = "main";

    public void interpret(Program program) {
        Runtime runtime = new Runtime(program.getFunctions());

        Context mainContext = new Context(runtime.getGlobalContext());
        runtime.enterState(new Invoke(new FunctionCall(MAIN_FUNCTION), mainContext));

        while (runtime.hasState()) {
            runtime.getState().run(runtime);
        }
    }
}
