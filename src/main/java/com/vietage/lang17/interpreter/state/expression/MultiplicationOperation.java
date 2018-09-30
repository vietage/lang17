package com.vietage.lang17.interpreter.state.expression;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.parser.ast.expression.MultiplicationExpression;
import com.vietage.lang17.parser.ast.expression.TwoOperandsExpression;

import java.util.function.Consumer;

public class MultiplicationOperation extends TwoOperandsOperation {

    private final MultiplicationExpression multiplicationExpression;

    public MultiplicationOperation(MultiplicationExpression multiplicationExpression,
                                   Context context, Consumer<Result> resultConsumer) {
        super(context, resultConsumer);
        this.multiplicationExpression = multiplicationExpression;
    }

    @Override
    protected Result getResult(Runtime runtime, Result leftOperand, Result rightOperand) {
        switch (multiplicationExpression.getOperator()) {
            case MULTIPLICATION:
                return runtime.getOperators().multiply(leftOperand, rightOperand);
            case DIVISION:
                return runtime.getOperators().divide(leftOperand, rightOperand);
            case MODULO:
                return runtime.getOperators().modulo(leftOperand, rightOperand);
            default:
                throw new RuntimeException("Unsupported multiplication operator: " +
                        multiplicationExpression.getOperator());
        }
    }

    @Override
    protected TwoOperandsExpression getTwoOperandsExpression() {
        return multiplicationExpression;
    }
}
