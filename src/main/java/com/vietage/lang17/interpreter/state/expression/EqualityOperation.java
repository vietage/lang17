package com.vietage.lang17.interpreter.state.expression;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.InterpreterException;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.BooleanResult;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.parser.ast.ASTElement;
import com.vietage.lang17.parser.ast.expression.EqualityExpression;
import com.vietage.lang17.parser.ast.expression.TwoOperandsExpression;

import java.util.function.Consumer;

public class EqualityOperation extends TwoOperandsOperation {

    private final EqualityExpression equalityExpression;

    public EqualityOperation(EqualityExpression equalityExpression, Context context, Consumer<Result> resultConsumer) {
        super(context, resultConsumer);
        this.equalityExpression = equalityExpression;
    }

    @Override
    protected Result getResult(Runtime runtime, Result leftOperand, Result rightOperand) {
        switch (equalityExpression.getOperator()) {
            case EQUAL:
                return runtime.getOperators().equal(leftOperand, rightOperand);
            case NOT_EQUAL:
                return not(runtime.getOperators().equal(leftOperand, rightOperand));
            default:
                throw new RuntimeException("Unsupported equality operator: " +
                        equalityExpression.getOperator());
        }
    }

    @Override
    protected TwoOperandsExpression getTwoOperandsExpression() {
        return equalityExpression;
    }

    private Result not(Result result) {
        if (result.isBoolean()) {
            return new BooleanResult(!result.getBoolean());
        }
        throw new InterpreterException(String.format("Unable to take not operation on %s type", result.getType()));
    }

    @Override
    public ASTElement getAstElement() {
        return equalityExpression;
    }
}
