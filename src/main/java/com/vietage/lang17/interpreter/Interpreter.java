package com.vietage.lang17.interpreter;

import com.vietage.lang17.interpreter.state.FunctionInvocation;
import com.vietage.lang17.parser.ast.Function;
import com.vietage.lang17.parser.ast.Program;

public class Interpreter {

    private static final String MAIN_FUNCTION = "main";

    public void interpret(Program program) {
        Runtime runtime = new Runtime(program.getFunctions());

        Function main = runtime.getFunction(MAIN_FUNCTION);
        Context mainContext = new Context(runtime.getGlobalContext());

        runtime.enterState(new FunctionInvocation(main, mainContext));

        while (runtime.hasState()) {
            runtime.getState().run(runtime);
        }
    }
}
