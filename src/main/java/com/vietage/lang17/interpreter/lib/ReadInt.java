package com.vietage.lang17.interpreter.lib;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.SystemFunction;
import com.vietage.lang17.interpreter.result.BooleanResult;
import com.vietage.lang17.interpreter.state.Return;
import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.parser.ast.Type;
import com.vietage.lang17.parser.ast.expression.IntegerConstant;
import com.vietage.lang17.parser.ast.statement.ReturnStatement;

import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadInt implements State {

    public static final String IS_OK_GLOBAL_VARIABLE = "__readInt_isOk";

    private final Context context;

    public ReadInt(Context context) {
        this.context = context;
    }

    public static SystemFunction getSystemFunction() {
        return new SystemFunction("readInt", Type.INTEGER, Collections.emptyList(), ReadInt::new);
    }

    @Override
    public void run(Runtime runtime) {
        runtime.exitState();

        try {
            int result = new Scanner(System.in).nextInt();

            runtime.getGlobalContext().set(IS_OK_GLOBAL_VARIABLE, new BooleanResult(true));

            runtime.enterState(new Return(new ReturnStatement(new IntegerConstant(result)), context));
        } catch (NoSuchElementException e) {
            runtime.getGlobalContext().set(IS_OK_GLOBAL_VARIABLE, new BooleanResult(false));
        }
    }
}
