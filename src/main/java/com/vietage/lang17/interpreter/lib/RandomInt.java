package com.vietage.lang17.interpreter.lib;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.InterpreterException;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.SystemFunction;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.state.Return;
import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.parser.ast.Argument;
import com.vietage.lang17.parser.ast.Type;
import com.vietage.lang17.parser.ast.expression.IntegerConstant;
import com.vietage.lang17.parser.ast.statement.ReturnStatement;

import java.util.Collections;
import java.util.Random;

public class RandomInt implements State {

    private static final Argument ARG_MAX = new Argument(Type.INTEGER, "max");
    private static final Random RANDOM = new Random();

    private final Context context;

    public static SystemFunction getSystemFunction() {
        return new SystemFunction("randomInt", Type.INTEGER, Collections.singletonList(ARG_MAX), RandomInt::new);
    }

    public RandomInt(Context context) {
        this.context = context;
    }

    @Override
    public void run(Runtime runtime) {
        runtime.exitState();

        Result max = context.get(ARG_MAX.getName());

        if (max.isInteger()) {
            long maxValue = max.getInteger();
            long random = RANDOM.nextLong() % maxValue;

            runtime.enterState(new Return(new ReturnStatement(new IntegerConstant(random)), context));
        } else {
            throw new InterpreterException(String.format("%s is not an integer!", ARG_MAX.getName()));
        }
    }
}
