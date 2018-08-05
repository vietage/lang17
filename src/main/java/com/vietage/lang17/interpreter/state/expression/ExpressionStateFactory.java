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
        public void visit(BooleanConstant booleanConstant) {
            result = new ReturnBoolean(booleanConstant, consumer);
        }

        @Override
        public void visit(StringConstant stringConstant) {
            result = new ReturnString(stringConstant, consumer);
        }

        @Override
        public void visit(IntegerConstant integerConstant) {
            result = new ReturnInteger(integerConstant, consumer);
        }

        @Override
        public void visit(FloatConstant floatConstant) {
            result = new ReturnFloat(floatConstant, consumer);
        }

        @Override
        public void visit(VariableRead variableRead) {
            result = new ReadVariable(variableRead, context, consumer);
        }

        @Override
        public void visit(ArrayRead arrayRead) {
            result = new ReadArray(arrayRead, context, consumer);
        }

        @Override
        public void visit(ArrayAllocation arrayAllocation) {
            result = new AllocateArray(arrayAllocation, context, consumer);
        }

        @Override
        public void visit(UnaryExpression unaryExpression) {
            result = new UnaryOperation(unaryExpression, context, consumer);
        }

        @Override
        public void visit(OrExpression orExpression) {
            result = new OrOperation(orExpression, context, consumer);
        }

        @Override
        public void visit(AndExpression andExpression) {
            result = new AndOperation(andExpression, context, consumer);
        }

        @Override
        public void visit(AdditionExpression additionExpression) {
            result = new AdditionOperation(additionExpression, context, consumer);
        }

        @Override
        public void visit(MultiplicationExpression multiplicationExpression) {
            result = new MultiplicationOperation(multiplicationExpression, context, consumer);
        }

        @Override
        public void visit(RelationalExpression relationalExpression) {
            result = new RelationalOperation(relationalExpression, context, consumer);
        }

        @Override
        public void visit(EqualityExpression equalityExpression) {
            result = new EqualityOperation(equalityExpression, context, consumer);
        }
    }
}
