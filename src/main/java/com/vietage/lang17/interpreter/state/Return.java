package com.vietage.lang17.interpreter.state;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.parser.ast.statement.ReturnStatement;

public class Return implements State {

    private final ReturnStatement returnStatement;
    private final Context context;

    private Result result;

    public Return(ReturnStatement returnStatement, Context context) {
        this.returnStatement = returnStatement;
        this.context = context;
    }

    @Override
    public void run(Runtime runtime) {
        if (result == null) {
            // compute return value
            ExpressionStateFactory factory = new ExpressionStateFactory();
            runtime.enterState(factory.get(returnStatement.getExpression(), context, this::setResult));
        } else {
            // return the result
            while (runtime.hasState()) {
                State state = runtime.getState();

                if (state instanceof Invoke) {
                    Invoke invoke = (Invoke) state;
                    invoke.setResult(result);
                    return;
                } else {
                    runtime.exitState();
                }
            }
        }
    }

    public void setResult(Result result) {
        this.result = result;
    }
}