package com.vietage.lang17.interpreter.lib;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.InterpreterException;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.SystemFunction;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.parser.ast.Argument;
import com.vietage.lang17.parser.ast.Type;

import java.util.Collections;

public class Print implements State {

    private static final Argument ARG_TEXT = new Argument(Type.STRING, "text");

    private final Context context;

    public Print(Context context) {
        this.context = context;
    }

    public static SystemFunction getSystemFunction() {
        return new SystemFunction("print", null, Collections.singletonList(ARG_TEXT), Print::new);
    }

    @Override
    public void run(Runtime runtime) {
        runtime.exitState();

        Result text = context.get(ARG_TEXT.getName());

        if (text.isString()) {
            String textValue = text.getString();

            System.out.print(textValue);
        } else {
            throw new InterpreterException(String.format("%s is not a string!", ARG_TEXT.getName()));
        }
    }
}
