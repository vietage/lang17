package com.vietage.lang17.interpreter.lib;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.SystemFunction;
import com.vietage.lang17.interpreter.result.*;
import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.parser.ast.Argument;
import com.vietage.lang17.parser.ast.Type;

import java.util.Arrays;
import java.util.Collections;

public class Println implements State, Result.Visitor {

    private static final Argument ARG_TEXT = new Argument(Type.STRING, "text");

    private final Context context;

    public Println(Context context) {
        this.context = context;
    }

    public static SystemFunction getSystemFunction() {
        return new SystemFunction("println", null, Collections.singletonList(ARG_TEXT), Println::new);
    }

    @Override
    public void run(Runtime runtime) {
        runtime.exitState();

        context.get(ARG_TEXT.getName()).accept(this);
    }

    @Override
    public void visit(IntegerResult integerResult) {
        System.out.println(integerResult.getInteger());
    }

    @Override
    public void visit(FloatResult floatResult) {
        System.out.println(floatResult.getFloat());
    }

    @Override
    public void visit(BooleanResult booleanResult) {
        System.out.println(booleanResult.getBoolean());
    }

    @Override
    public void visit(StringResult stringResult) {
        System.out.println(stringResult.getString());
    }

    @Override
    public void visit(IntegerArrayResult integerArrayResult) {
        System.out.println(Arrays.toString(integerArrayResult.getIntegerArray()));
    }

    @Override
    public void visit(FloatArrayResult floatArrayResult) {
        System.out.println(Arrays.toString(floatArrayResult.getFloatArray()));
    }

    @Override
    public void visit(BooleanArrayResult booleanArrayResult) {
        System.out.println(Arrays.toString(booleanArrayResult.getBooleanArray()));
    }

    @Override
    public void visit(StringArrayResult stringArrayResult) {
        System.out.println(Arrays.toString(stringArrayResult.getStringArray()));
    }
}
