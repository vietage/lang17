package com.vietage.lang17.interpreter.state;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.state.expression.ExpressionStateFactory;
import com.vietage.lang17.interpreter.state.expression.Invoke;
import com.vietage.lang17.lexer.Position;
import com.vietage.lang17.parser.ast.PositionalElement;
import com.vietage.lang17.parser.ast.statement.ReturnStatement;

public class Return extends TwoPhaseState implements PositionalElement {

    private final ReturnStatement returnStatement;
    private final Context context;

    private Result result;

    public Return(ReturnStatement returnStatement, Context context) {
        this.returnStatement = returnStatement;
        this.context = context;
    }

    @Override
    protected void onInitialize(Runtime runtime) {
        // compute return value
        ExpressionStateFactory factory = new ExpressionStateFactory();
        runtime.enterState(factory.get(returnStatement.getExpression(), context, this::setResult));
    }

    @Override
    protected void onReturn(Runtime runtime) {
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

    @Override
    public Position getPosition() {
        return returnStatement.getPosition();
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
