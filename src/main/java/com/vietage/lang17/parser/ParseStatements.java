package com.vietage.lang17.parser;

import com.vietage.lang17.lexer.lexeme.Assignment;
import com.vietage.lang17.lexer.lexeme.Block;
import com.vietage.lang17.lexer.lexeme.Call;
import com.vietage.lang17.lexer.lexeme.LoopOp;
import com.vietage.lang17.lexer.lexeme.ReturnStatement;
import com.vietage.lang17.lexer.lexeme.StatementAndWhitespace;
import com.vietage.lang17.lexer.lexeme.VarDefinition;
import com.vietage.lang17.parser.ast.statement.IfStatement;
import com.vietage.lang17.parser.ast.statement.Statement;
import com.vietage.lang17.parser.ast.statement.VariableAssignment;
import com.vietage.lang17.parser.ast.statement.VariableDefinition;
import com.vietage.lang17.parser.ast.statement.WhileLoop;

import java.util.ArrayList;
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

        // parse right hand expression
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
    public void visit(com.vietage.lang17.lexer.lexeme.IfStatement ifLexeme) {
        IfStatement ifStatement = new IfStatement();

        // parse condition
        commandQueue.add(new ParseExpression(
                ifLexeme.getBracketsExpression().getExpression(),
                ifStatement::setCondition
        ));

        // parse true branch statements
        commandQueue.add(new ParseStatements(
                ifLexeme.getBlock(),
                statement -> ifStatement.getTrueStatements().add(statement)
        ));

        // parse false branch statements
        if (ifLexeme.getElseBlock().getResult()) {
            ifStatement.setFalseStatements(new ArrayList<>());

            commandQueue.add(new ParseStatements(
                    ifLexeme.getElseBlock().getElement().getBlock(),
                    statement -> ifStatement.getFalseStatements().add(statement)
            ));
        }

        action.doAction(ifStatement);
    }

    @Override
    public void visit(com.vietage.lang17.lexer.lexeme.WhileLoop whileLexeme) {
        WhileLoop whileLoop = new WhileLoop();

        // parse condition
        commandQueue.add(new ParseExpression(
                whileLexeme.getBracketsExpression().getExpression(),
                whileLoop::setCondition
        ));

        // parse statements
        commandQueue.add(new ParseStatements(
                whileLexeme.getBlock(),
                statement -> whileLoop.getStatements().add(statement)
        ));

        action.doAction(whileLoop);
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
