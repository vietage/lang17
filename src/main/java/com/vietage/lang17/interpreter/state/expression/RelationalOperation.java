package com.vietage.lang17.interpreter.state.expression;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.parser.ast.expression.RelationalExpression;
import com.vietage.lang17.parser.ast.expression.TwoOperandsExpression;

import java.util.function.Consumer;

public class RelationalOperation extends TwoOperandsOperation {

    private final RelationalExpression relationalExpression;

    public RelationalOperation(RelationalExpression relationalExpression, Context context,
                               Consumer<Result> resultConsumer) {
        super(context, resultConsumer);
        this.relationalExpression = relationalExpression;
    }

    @Override
    protected Result getResult(Runtime runtime, Result leftOperand, Result rightOperand) {
        switch (relationalExpression.getOperator()) {
            case LESS_OR_EQUAL:
                return runtime.getNumberOperations().lessOrEqual(leftOperand, rightOperand);
            case GREATER_OR_EQUAL:
                return runtime.getNumberOperations().greaterOrEqual(leftOperand, rightOperand);
            case LESS:
                return runtime.getNumberOperations().less(leftOperand, rightOperand);
            case GREATER:
                return runtime.getNumberOperations().greater(leftOperand, rightOperand);
            default:
                throw new RuntimeException("Unsupported relational operator: " +
                        relationalExpression.getOperator());
        }
    }

    @Override
    protected TwoOperandsExpression getTwoOperandsExpression() {
        return relationalExpression;
    }
}
