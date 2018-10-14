package com.vietage.lang17.interpreter.state.expression;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Function;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.state.TwoPhaseState;
import com.vietage.lang17.lexer.Position;
import com.vietage.lang17.parser.ast.Argument;
import com.vietage.lang17.parser.ast.PositionalElement;
import com.vietage.lang17.parser.ast.expression.Expression;
import com.vietage.lang17.parser.ast.expression.FunctionCall;

import java.util.Iterator;
import java.util.function.Consumer;

public class Invoke extends TwoPhaseState implements PositionalElement {

    private final FunctionCall functionCall;
    private final Context context;
    private final Consumer<Result> resultConsumer;

    private Result result;

    public Invoke(FunctionCall functionCall, Context context) {
        this(functionCall, context, null);
    }

    public Invoke(FunctionCall functionCall, Context context, Consumer<Result> resultConsumer) {
        this.functionCall = functionCall;
        this.context = context;
        this.resultConsumer = resultConsumer;
    }

    @Override
    protected void onInitialize(Runtime runtime) {
        // compute arguments and then interpret block statements
        Function function = runtime.getFunction(functionCall.getName());

        Context functionContext = new Context(runtime.getGlobalContext());
        runtime.enterState(function.getBodyState(functionContext));

        ExpressionStateFactory factory = new ExpressionStateFactory();

        Iterator<Argument> arguments = function.getArguments().iterator();
        Iterator<Expression> expressions = functionCall.getArguments().iterator();

        while (arguments.hasNext() && expressions.hasNext()) {
            Argument argument = arguments.next();
            Expression expression = expressions.next();

            Consumer<Result> consumer = result -> functionContext.set(argument.getName(), result);

            runtime.enterState(factory.get(expression, context, consumer));
        }
    }

    @Override
    protected void onReturn(Runtime runtime) {
        // return result from the function
        if (result != null && resultConsumer != null) {
            resultConsumer.accept(result);
        }
    }

    @Override
    public Position getPosition() {
        return functionCall.getPosition();
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public FunctionCall getFunctionCall() {
        return functionCall;
    }
}
