package com.vietage.lang17.interpreter.state.expression;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.parser.ast.expression.AdditionExpression;
import com.vietage.lang17.parser.ast.expression.TwoOperandsExpression;

import java.util.function.Consumer;

public class AdditionOperation extends TwoOperandsOperation {

    private final AdditionExpression additionExpression;

    public AdditionOperation(AdditionExpression additionExpression, Context context, Consumer<Result> resultConsumer) {
        super(context, resultConsumer);
        this.additionExpression = additionExpression;
    }

    @Override
    protected Result getResult(Runtime runtime, Result leftOperand, Result rightOperand) {
        switch (additionExpression.getOperator()) {
            case ADDITION:
                return runtime.getNumberOperations().add(leftOperand, rightOperand);
            case SUBTRACTION:
                return runtime.getNumberOperations().subtract(leftOperand, rightOperand);
            default:
                throw new RuntimeException("Unsupported addition operator: " +
                        additionExpression.getOperator());
        }
    }

    @Override
    protected TwoOperandsExpression getTwoOperandsExpression() {
        return additionExpression;
    }
}
