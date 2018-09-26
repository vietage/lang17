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

public class SizeInt implements State {

    private static final Argument ARG_ARRAY = new Argument(Type.INTEGER_ARRAY, "array");

    private final Context context;

    public SizeInt(Context context) {
        this.context = context;
    }

    public static SystemFunction getSystemFunction() {
        return new SystemFunction("sizeInt", Type.INTEGER, Collections.singletonList(ARG_ARRAY), SizeInt::new);
    }

    @Override
    public void run(Runtime runtime) {
        runtime.exitState();

        Result array = context.get(ARG_ARRAY.getName());

        if (array.isIntegerArray()) {
            int arraySize = array.getIntegerArray().length;

            runtime.enterState(new Return(new ReturnStatement(new IntegerConstant(arraySize)), context));
        } else {
            throw new InterpreterException(String.format("%s is not an integer array!", ARG_ARRAY.getName()));
        }
    }
}
