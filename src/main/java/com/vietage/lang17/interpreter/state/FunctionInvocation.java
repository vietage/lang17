package com.vietage.lang17.interpreter.state;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.parser.ast.Function;
import com.vietage.lang17.parser.ast.expression.FunctionCall;
import com.vietage.lang17.parser.ast.statement.*;

import java.util.Iterator;
import java.util.function.Consumer;

public class FunctionInvocation implements State, Statement.Visitor {

    private final Function function;
    private final Context context;
    private final Consumer<Result> resultConsumer;

    private Runtime runtime;
    private Iterator<Statement> statements;
    private Result result;

    public FunctionInvocation(Function function, Context context) {
        this(function, context, null);
    }

    public FunctionInvocation(Function function, Context context, Consumer<Result> resultConsumer) {
        this.function = function;
        this.context = context;
        this.resultConsumer = resultConsumer;
    }

    @Override
    public void run(Runtime runtime) {
        this.runtime = runtime;

        if (statements == null) {
            statements = function.getStatements().iterator();
        }

        if (statements.hasNext()) {
            statements.next().accept(this);
        } else {
            runtime.exitState();

            if (result != null && resultConsumer != null) {
                resultConsumer.accept(result);
            }
        }
    }

    @Override
    public void visit(ContinueStatement continueStatement) {
        runtime.enterState(new Continue());
    }

    @Override
    public void visit(BreakStatement breakStatement) {
        runtime.enterState(new Break());
    }

    @Override
    public void visit(FunctionCall functionCall) {
        runtime.enterState(new Invoke(functionCall, context));
    }

    @Override
    public void visit(WhileLoop whileLoop) {

    }

    @Override
    public void visit(ReturnStatement returnStatement) {

    }

    @Override
    public void visit(IfStatement ifStatement) {

    }

    @Override
    public void visit(VariableDefinition variableDefinition) {

    }

    @Override
    public void visit(VariableAssignment variableAssignment) {

    }

    public void setResult(Result result) {
        this.result = result;
    }
}
