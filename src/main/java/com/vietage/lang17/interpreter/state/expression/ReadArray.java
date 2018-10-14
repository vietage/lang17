package com.vietage.lang17.interpreter.state.expression;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.InterpreterException;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.lexer.Position;
import com.vietage.lang17.parser.ast.PositionalElement;
import com.vietage.lang17.parser.ast.expression.ArrayRead;

import java.util.function.Consumer;

public class ReadArray implements State, PositionalElement {

    private final ArrayRead arrayRead;
    private final Context context;
    private final Consumer<Result> resultConsumer;

    private boolean init = true;
    private Result indexExpressionResult;

    public ReadArray(ArrayRead arrayRead, Context context, Consumer<Result> resultConsumer) {
        this.arrayRead = arrayRead;
        this.context = context;
        this.resultConsumer = resultConsumer;
    }

    @Override
    public void run(Runtime runtime) {
        if (init) {
            init = false;

            ExpressionStateFactory factory = new ExpressionStateFactory();

            runtime.enterState(factory.get(arrayRead.getIndexExpression(), context,
                    result -> indexExpressionResult = result));
        } else if (indexExpressionResult.isInteger()) {
            runtime.exitState();

            int index = Long.valueOf(indexExpressionResult.getInteger()).intValue();

            resultConsumer.accept(context.get(arrayRead.getName(), index));
        } else {
            throw new InterpreterException(String.format(
                    "Unsupported type used as array index: %s", indexExpressionResult));
        }
    }

    @Override
    public Position getPosition() {
        return arrayRead.getPosition();
    }
}
