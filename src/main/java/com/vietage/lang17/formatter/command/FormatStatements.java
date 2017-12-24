package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.FunctionCall;
import com.vietage.lang17.parser.ast.statement.*;

import java.util.List;
import java.util.Queue;

public class FormatStatements extends FormatCommand implements Statement.Visitor {

    private final List<Statement> statements;
    private Queue<FormatCommand> commands;

    public FormatStatements(int indent, List<Statement> statements) {
        super(indent);
        this.statements = statements;
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {
        this.commands = commandQueue;

        for (Statement statement : statements) {
            statement.accept(this);
        }
    }

    @Override
    public void visit(ContinueStatement continueStatement) {
        commands.add(new FormatContinueStatement(indent));
    }

    @Override
    public void visit(BreakStatement breakStatement) {
        commands.add(new FormatBreakStatement(indent));
    }

    @Override
    public void visit(FunctionCall functionCall) {
        commands.add(new FormatFunctionCall(indent, functionCall));
        commands.add(new InsertLineFeed(indent));
    }

    @Override
    public void visit(WhileLoop whileLoop) {
        commands.add(new FormatWhileLoop(indent, whileLoop));
    }

    @Override
    public void visit(ReturnStatement returnStatement) {
        commands.add(new FormatReturnStatement(indent, returnStatement));
    }

    @Override
    public void visit(IfStatement ifStatement) {
        commands.add(new FormatIfStatement(indent, ifStatement));
    }

    @Override
    public void visit(VariableDefinition variableDefinition) {
        commands.add(new FormatVariableDefinition(indent, variableDefinition));
    }

    @Override
    public void visit(VariableAssignment variableAssignment) {
        commands.add(new FormatVariableAssignment(indent, variableAssignment));
    }
}
