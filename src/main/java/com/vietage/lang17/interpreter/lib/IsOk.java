package com.vietage.lang17.interpreter.lib;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.InterpreterException;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.SystemFunction;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.state.Return;
import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.parser.ast.Type;
import com.vietage.lang17.parser.ast.expression.BooleanConstant;
import com.vietage.lang17.parser.ast.statement.ReturnStatement;

import java.util.Collections;

public class IsOk implements State {

    private final Context context;

    public IsOk(Context context) {
        this.context = context;
    }

    public static SystemFunction getSystemFunction() {
        return new SystemFunction("isOk", Type.BOOLEAN, Collections.emptyList(), IsOk::new);
    }

    @Override
    public void run(Runtime runtime) {
        runtime.exitState();

        Result result = runtime.getGlobalContext().get(ReadInt.IS_OK_GLOBAL_VARIABLE);

        if (result.isBoolean()) {
            runtime.enterState(new Return(new ReturnStatement(new BooleanConstant(result.getBoolean())), context));
        } else {
            throw new InterpreterException(String.format("%s is not a boolean", ReadInt.IS_OK_GLOBAL_VARIABLE));
        }
    }
}
