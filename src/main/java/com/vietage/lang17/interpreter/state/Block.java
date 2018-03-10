package com.vietage.lang17.interpreter.state;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.parser.ast.expression.FunctionCall;
import com.vietage.lang17.parser.ast.statement.*;

import java.util.Iterator;

public class Block implements State, Statement.Visitor {

    private final Context context;
    private final Iterator<Statement> statements;

    private Runtime runtime;

    public Block(Context context, Iterator<Statement> statements) {
        this.context = context;
        this.statements = statements;
    }

    @Override
    public void run(Runtime runtime) {
        this.runtime = runtime;

        if (statements.hasNext()) {
            statements.next().accept(this);
        } else {
            runtime.exitState();
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
        runtime.enterState(new While(whileLoop, context));
    }

    @Override
    public void visit(ReturnStatement returnStatement) {
        runtime.enterState(new Return(returnStatement, context));
    }

    @Override
    public void visit(IfStatement ifStatement) {
        runtime.enterState(new If(ifStatement, context));
    }

    @Override
    public void visit(VariableDefinition variableDefinition) {

    }

    @Override
    public void visit(VariableAssignment variableAssignment) {

    }
}
