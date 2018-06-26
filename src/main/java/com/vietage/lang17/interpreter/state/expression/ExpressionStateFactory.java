package com.vietage.lang17.interpreter.state.expression;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.parser.ast.expression.*;

import java.util.function.Consumer;

public class ExpressionStateFactory {

    public State get(Expression expression, Context context, Consumer<Result> consumer) {
        Visitor visitor = new Visitor(context, consumer);

        expression.accept(visitor);

        return visitor.result;
    }

    private class Visitor implements Expression.Visitor {

        private final Context context;
        private final Consumer<Result> consumer;

        private State result;

        public Visitor(Context context, Consumer<Result> consumer) {
            this.context = context;
            this.consumer = consumer;
        }

        @Override
        public void visit(FunctionCall functionCall) {
            result = new Invoke(functionCall, context, consumer);
        }

        @Override
        public void visit(UnaryExpression unaryExpression) {
            result = new UnaryOperation(unaryExpression, context, consumer);
        }

        @Override
        public void visit(BooleanConstant booleanConstant) {

        }

        @Override
        public void visit(StringConstant stringConstant) {

        }

        @Override
        public void visit(IntegerConstant integerConstant) {

        }

        @Override
        public void visit(FloatConstant floatConstant) {

        }

        @Override
        public void visit(VariableRead variableRead) {

        }

        @Override
        public void visit(MultiplicationExpression multiplicationExpression) {

        }

        @Override
        public void visit(OrExpression orExpression) {

        }

        @Override
        public void visit(AdditionExpression additionExpression) {

        }

        @Override
        public void visit(RelationalExpression relationalExpression) {

        }

        @Override
        public void visit(EqualityExpression equalityExpression) {

        }

        @Override
        public void visit(ArrayRead arrayRead) {

        }

        @Override
        public void visit(ArrayAllocation arrayAllocation) {

        }

        @Override
        public void visit(AndExpression andExpression) {

        }
    }
}