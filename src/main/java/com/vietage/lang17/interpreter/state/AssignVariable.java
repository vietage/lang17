package com.vietage.lang17.interpreter.state;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.parser.ast.statement.VariableAssignment;

import java.util.function.Consumer;

public class AssignVariable implements State {

    private final VariableAssignment variableAssignment;
    private final Context context;

    private int index;

    public AssignVariable(VariableAssignment variableAssignment, Context context) {
        this.variableAssignment = variableAssignment;
        this.context = context;
    }

    @Override
    public void run(Runtime runtime) {
        runtime.exitState();

        ExpressionStateFactory factory = new ExpressionStateFactory();

        if (variableAssignment.getIndexExpression() != null) {
            // array element assignment - first compute index then compute value
            // and assign it to the array element

            // compute value and assign
            Consumer<Result> valueConsumer = result ->
                    context.set(variableAssignment.getName(), this.getIndex(), result);
            runtime.enterState(factory.get(variableAssignment.getExpression(), context, valueConsumer));

            // compute index
            Consumer<Result> indexConsumer = result -> this.setIndex(result.getInteger());
            runtime.enterState(factory.get(variableAssignment.getIndexExpression(), context, indexConsumer));
        } else {
            // simple variable assignment - just compute the value and assign it to the variable
            Consumer<Result> resultConsumer = result -> context.set(variableAssignment.getName(), result);
            runtime.enterState(factory.get(variableAssignment.getExpression(), context, resultConsumer));
        }
    }

    private void setIndex(int index) {
        this.index = index;
    }

    private int getIndex() {
        return index;
    }
}
