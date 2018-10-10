package com.vietage.lang17.interpreter.state.expression;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.InterpreterException;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.*;
import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.parser.ast.Type;
import com.vietage.lang17.parser.ast.expression.ArrayAllocation;

import java.util.function.Consumer;

public class AllocateArray implements State {

    private final ArrayAllocation arrayAllocation;
    private final Context context;
    private final Consumer<Result> resultConsumer;

    private boolean init = true;
    private Result sizeExpressionResult;

    public AllocateArray(ArrayAllocation arrayAllocation, Context context, Consumer<Result> resultConsumer) {
        this.arrayAllocation = arrayAllocation;
        this.context = context;
        this.resultConsumer = resultConsumer;
    }

    @Override
    public void run(Runtime runtime) {
        if (init) {
            init = false;

            ExpressionStateFactory factory = new ExpressionStateFactory();

            runtime.enterState(factory.get(arrayAllocation.getSizeExpression(), context,
                    result -> sizeExpressionResult = result));
        } else if (sizeExpressionResult.isInteger()) {
            runtime.exitState();

            int size = Long.valueOf(sizeExpressionResult.getInteger()).intValue();

            resultConsumer.accept(allocateArray(arrayAllocation.getType(), size));
        } else {
            throw new InterpreterException(String.format(
                    "Unsupported type used as array size: %s", sizeExpressionResult));
        }
    }

    private Result allocateArray(Type type, int size) {
        switch (type) {
            case INTEGER_ARRAY:
                return new IntegerArrayResult(new long[size]);
            case FLOAT_ARRAY:
                return new FloatArrayResult(new double[size]);
            case BOOLEAN_ARRAY:
                return new BooleanArrayResult(new boolean[size]);
            case STRING_ARRAY:
                return new StringArrayResult(new String[size]);
            default:
                throw new InterpreterException(String.format("Illegal try to allocate array of type: %s", type));
        }
    }
}
