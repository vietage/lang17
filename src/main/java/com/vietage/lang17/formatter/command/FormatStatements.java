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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class FormatStatements extends FormatCommand implements Statement.Visitor {

    private final List<Statement> statements;
    private Deque<FormatCommand> commands;

    public FormatStatements(int indent, List<Statement> statements) {
        super(indent);
        this.statements = statements;
    }

    @Override
    public void format(IndentPrintStream out, Deque<FormatCommand> commands) {
        this.commands = commands;

        Iterator<Statement> it = getReverseIterator();

        while (it.hasNext()) {
            it.next().visit(this);
        }
    }

    private Iterator<Statement> getReverseIterator() {
        return new ArrayDeque<>(statements).descendingIterator();
    }

    @Override
    public void visit(ContinueStatement continueStatement) {
        commands.push(new FormatContinueStatement(indent));
    }

    @Override
    public void visit(BreakStatement breakStatement) {
        commands.push(new FormatBreakStatement(indent));
    }

    @Override
    public void visit(FunctionCall functionCall) {
        commands.push(new InsertLineFeed(indent));
        commands.push(new FormatFunctionCall(indent, functionCall));
    }

    @Override
    public void visit(WhileLoop whileLoop) {
        commands.push(new FormatWhileLoop(indent, whileLoop));
    }

    @Override
    public void visit(ReturnStatement returnStatement) {
        commands.push(new FormatReturnStatement(indent, returnStatement));
    }

    @Override
    public void visit(IfStatement ifStatement) {
        commands.push(new FormatIfStatement(indent, ifStatement));
    }

    @Override
    public void visit(VariableDefinition variableDefinition) {
        commands.push(new FormatVariableDefinition(indent, variableDefinition));
    }

    @Override
    public void visit(VariableAssignment variableAssignment) {
        commands.push(new FormatVariableAssignment(indent, variableAssignment));
    }
}
