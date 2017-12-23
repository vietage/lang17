package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.FunctionCall;
import com.vietage.lang17.parser.ast.statement.BreakStatement;
import com.vietage.lang17.parser.ast.statement.ContinueStatement;
import com.vietage.lang17.parser.ast.statement.IfStatement;
import com.vietage.lang17.parser.ast.statement.ReturnStatement;
import com.vietage.lang17.parser.ast.statement.Statement;
import com.vietage.lang17.parser.ast.statement.VariableAssignment;
import com.vietage.lang17.parser.ast.statement.VariableDefinition;
import com.vietage.lang17.parser.ast.statement.WhileLoop;

import java.util.Deque;
import java.util.List;

public class FormatStatements extends FormatCommand implements Statement.Visitor {

    private final List<Statement> statements;
    private Deque<FormatCommand> commands;

    public FormatStatements(int indent, List<Statement> statements) {
        super(indent);
        this.statements = statements;
    }

    @Override
    public void format(IndentPrintStream out, Deque<FormatCommand> commandQueue) {
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
