package com.vietage.lang17.interpreter.state.expression;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.BooleanResult;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.lexer.Position;
import com.vietage.lang17.parser.ast.PositionalElement;
import com.vietage.lang17.parser.ast.expression.Expression;
import com.vietage.lang17.parser.ast.expression.OrExpression;

import java.util.Iterator;
import java.util.function.Consumer;

public class OrOperation implements State, PositionalElement {

    private final OrExpression orExpression;
    private final Context context;
    private final Consumer<Result> resultConsumer;
    private final Iterator<Expression> expressions;

    private Result lastResult;
    private boolean result = false;

    public OrOperation(OrExpression orExpression, Context context, Consumer<Result> resultConsumer) {
        this.orExpression = orExpression;
        this.context = context;
        this.resultConsumer = resultConsumer;
        this.expressions = orExpression.getExpressions().iterator();
    }

    @Override
    public void run(Runtime runtime) {
        if (lastResult != null) {
            result |= lastResult.getBoolean();
        }
        if (!result && expressions.hasNext()) {
            Expression expression = expressions.next();

            ExpressionStateFactory factory = new ExpressionStateFactory();
            Consumer<Result> lastResultConsumer = result -> lastResult = result;

            runtime.enterState(factory.get(expression, context, lastResultConsumer));
        } else {
            runtime.exitState();
            resultConsumer.accept(new BooleanResult(result));
        }
    }

    @Override
    public Position getPosition() {
        return orExpression.getPosition();
    }
}
