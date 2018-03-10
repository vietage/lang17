package com.vietage.lang17.interpreter.state;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.parser.ast.Argument;
import com.vietage.lang17.parser.ast.Function;
import com.vietage.lang17.parser.ast.expression.Expression;
import com.vietage.lang17.parser.ast.expression.FunctionCall;

import java.util.Iterator;
import java.util.function.Consumer;

public class Invoke implements State {

    private final FunctionCall functionCall;
    private final Context context;
    private final Consumer<Result> resultConsumer;

    private boolean init = true;
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
    public void run(Runtime runtime) {
        if (init) {
            // compute arguments and then interpret block statements
            init = false;

            Function function = runtime.getFunction(functionCall.getName());

            Context functionContext = new Context(runtime.getGlobalContext());
            runtime.enterState(new Block(functionContext, function.getStatements().iterator()));

            ExpressionStateFactory factory = new ExpressionStateFactory();

            Iterator<Argument> arguments = function.getArguments().iterator();
            Iterator<Expression> expressions = functionCall.getArguments().iterator();

            while (arguments.hasNext() && expressions.hasNext()) {
                Argument argument = arguments.next();
                Expression expression = expressions.next();

                Consumer<Result> consumer = result -> functionContext.set(argument.getName(), result);

                runtime.enterState(factory.get(expression, context, consumer));
            }
        } else {
            // return result from the function
            runtime.exitState();

            if (result != null && resultConsumer != null) {
                resultConsumer.accept(result);
            }
        }
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
