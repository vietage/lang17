package com.vietage.lang17.parser;

import com.vietage.lang17.lexer.lexeme.*;
import com.vietage.lang17.parser.ast.statement.Statement;
import com.vietage.lang17.parser.ast.statement.VariableAssignment;
import com.vietage.lang17.parser.ast.statement.VariableDefinition;

import java.util.Queue;

public class ParseStatements extends ParseCommand
        <com.vietage.lang17.lexer.lexeme.Block, Statement>
        implements com.vietage.lang17.lexer.lexeme.Statement.Visitor {

    private Queue<ParseCommand> commandQueue;

    public ParseStatements(Block lexeme, ParseAction<Statement> action) {
        super(lexeme, action);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {
        this.commandQueue = commandQueue;

        for (StatementAndWhitespace statementAndWhitespace : lexeme.getStatements()) {
            statementAndWhitespace.getStatementChoice().getStatement().accept(this);
        }
    }

    @Override
    public void visit(VarDefinition varDefinition) {
        VariableDefinition variableDefinition = new VariableDefinition(
                varDefinition.getType().getType(),
                varDefinition.getName().getResult()
        );

        commandQueue.add(new ParseExpression(
                varDefinition.getExpression(),
                variableDefinition::setExpression
        ));

        action.doAction(variableDefinition);
    }

    @Override
    public void visit(Assignment assignment) {
        String name = assignment.getVarAccess().getName().getResult();

        VariableAssignment variableAssignment = new VariableAssignment(name);

        // parse array index expression
        if (assignment.getVarAccess().getIndexExpression().getResult()) {
            commandQueue.add(new ParseExpression(
                    assignment.getVarAccess().getIndexExpression().getElement().getExpression(),
                    variableAssignment::setIndexExpression
            ));
        }

        // parse right hand expression
        commandQueue.add(new ParseExpression(
                assignment.getExpression(),
                variableAssignment::setExpression
        ));

        action.doAction(variableAssignment);
    }

    @Override
    public void visit(IfStatement ifStatement) {

    }

    @Override
    public void visit(WhileLoop whileLoop) {

    }

    @Override
    public void visit(LoopOp loopOp) {

    }

    @Override
    public void visit(Call call) {

    }

    @Override
    public void visit(ReturnStatement returnStatement) {

    }
}
