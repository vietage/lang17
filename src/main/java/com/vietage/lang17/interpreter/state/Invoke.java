package com.vietage.lang17.interpreter.state;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.InterpreterException;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.parser.ast.Function;
import com.vietage.lang17.parser.ast.expression.Expression;
import com.vietage.lang17.parser.ast.expression.FunctionCall;
import com.vietage.lang17.parser.ast.statement.*;

import java.util.Iterator;
import java.util.function.Consumer;

public class Invoke implements State, Statement.Visitor {

    private final Context context;
    private final String name;
    private final Consumer<Result> resultConsumer;

    private Runtime runtime;
    private Iterator<Statement> statements;
    private Result result;

    public Invoke(Context context, String name) {
        this(context, name, null);
    }

    public Invoke(Context context, String name, Consumer<Result> resultConsumer) {
        this.context = context;
        this.name = name;
        this.resultConsumer = resultConsumer;
    }

    @Override
    public void run(Runtime runtime) {
        this.runtime = runtime;

        if (statements == null) {
            Function function = runtime.getFunction(name);

            if (function == null) {
                throw new InterpreterException(String.format("Function `%s` not found", name));
            }

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
        Context functionContext = new Context(runtime.getGlobalContext());
        runtime.enterState(new Invoke(functionContext, functionCall.getName()));

        for (Expression expression : functionCall.getArguments()) {

        }
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
