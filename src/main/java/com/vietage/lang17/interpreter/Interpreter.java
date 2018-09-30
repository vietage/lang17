package com.vietage.lang17.interpreter;

import com.vietage.lang17.interpreter.state.expression.Invoke;
import com.vietage.lang17.parser.ast.Program;
import com.vietage.lang17.parser.ast.expression.FunctionCall;

public class Interpreter {

    private static final String MAIN_FUNCTION = "main";

    public void interpret(Program program) {
        Runtime runtime = new Runtime(new Functions(program));

        Context mainContext = new Context(runtime.getGlobalContext());
        runtime.enterState(new Invoke(new FunctionCall(MAIN_FUNCTION), mainContext));

        try {
            while (runtime.hasState()) {
                runtime.getState().run(runtime);
            }
        } catch (InterpreterException e) {
            printStackTrace(runtime);
            e.printStackTrace();
        }
    }

    private void printStackTrace(Runtime runtime) {
        new StackTracePrinter(System.err).print(runtime);
    }
}
