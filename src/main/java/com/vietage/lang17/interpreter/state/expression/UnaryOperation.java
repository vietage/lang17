package com.vietage.lang17.interpreter.state.expression;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.InterpreterException;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.BooleanResult;
import com.vietage.lang17.interpreter.result.FloatResult;
import com.vietage.lang17.interpreter.result.IntegerResult;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.lexer.Position;
import com.vietage.lang17.parser.ast.PositionalElement;
import com.vietage.lang17.parser.ast.expression.UnaryExpression;

import java.util.function.Consumer;

public class UnaryOperation implements State, PositionalElement {

    private final UnaryExpression unaryExpression;
    private final Context context;
    private final Consumer<Result> resultConsumer;

    public UnaryOperation(UnaryExpression unaryExpression, Context context, Consumer<Result> resultConsumer) {
        this.unaryExpression = unaryExpression;
        this.context = context;
        this.resultConsumer = resultConsumer;
    }

    @Override
    public void run(Runtime runtime) {
        runtime.exitState();

        ExpressionStateFactory factory = new ExpressionStateFactory();

        switch (unaryExpression.getOperator()) {
            case NOT:
                Consumer<Result> notConsumer = result -> resultConsumer.accept(not(result));

                runtime.enterState(factory.get(unaryExpression.getExpression(), context, notConsumer));
                break;
            case MINUS:
                Consumer<Result> negateConsumer = result -> resultConsumer.accept(negate(result));

                runtime.enterState(factory.get(unaryExpression.getExpression(), context, negateConsumer));
                break;
            default:
                throw new RuntimeException("Unsupported unary operator: " + unaryExpression.getOperator());
        }
    }

    @Override
    public Position getPosition() {
        return unaryExpression.getPosition();
    }

    private Result not(Result result) {
        if (result.isBoolean()) {
            return new BooleanResult(!result.getBoolean());
        }
        throw new InterpreterException(String.format("Unable to take not operation on %s type", result.getType()));
    }

    private Result negate(Result result) {
        Result[] returnValue = new Result[1];

        result.accept(new Result.Visitor() {
            @Override
            public void visit(IntegerResult integerResult) {
                returnValue[0] = new IntegerResult(-integerResult.getInteger());
            }

            @Override
            public void visit(FloatResult floatResult) {
                returnValue[0] = new FloatResult(-floatResult.getFloat());
            }
        });

        return returnValue[0];
    }
}
