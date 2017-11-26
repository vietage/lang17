package com.vietage.lang17.parser;

import com.vietage.lang17.lexer.lexeme.Assignment;
import com.vietage.lang17.lexer.lexeme.Block;
import com.vietage.lang17.lexer.lexeme.Call;
import com.vietage.lang17.lexer.lexeme.LoopOp;
import com.vietage.lang17.lexer.lexeme.RestExpressions;
import com.vietage.lang17.lexer.lexeme.StatementAndWhitespace;
import com.vietage.lang17.lexer.lexeme.StatementChoiceElement;
import com.vietage.lang17.lexer.lexeme.VarDefinition;
import com.vietage.lang17.parser.ast.expression.Expression;
import com.vietage.lang17.parser.ast.expression.FunctionCall;
import com.vietage.lang17.parser.ast.statement.BreakStatement;
import com.vietage.lang17.parser.ast.statement.ContinueStatement;
import com.vietage.lang17.parser.ast.statement.IfStatement;
import com.vietage.lang17.parser.ast.statement.ReturnStatement;
import com.vietage.lang17.parser.ast.statement.Statement;
import com.vietage.lang17.parser.ast.statement.VariableAssignment;
import com.vietage.lang17.parser.ast.statement.VariableDefinition;
import com.vietage.lang17.parser.ast.statement.WhileLoop;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ParseStatements extends ParseCommand
        <com.vietage.lang17.lexer.lexeme.Block, Statement>
        implements StatementChoiceElement.Visitor {

    private Queue<ParseCommand> commandQueue;

    public ParseStatements(Block lexeme, ResultConsumer<Statement> action) {
        super(lexeme, action);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {
        this.commandQueue = commandQueue;

        for (StatementAndWhitespace statementAndWhitespace : lexeme.getStatements()) {
            statementAndWhitespace.getStatementChoice().getStatementChoiceElement().accept(this);
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

        resultConsumer.consume(variableDefinition);
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

        resultConsumer.consume(variableAssignment);
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

        resultConsumer.consume(ifStatement);
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

        resultConsumer.consume(whileLoop);
    }

    @Override
    public void visit(LoopOp loopOp) {
        if (loopOp.isBreak()) {
            resultConsumer.consume(new BreakStatement());
        }
        if (loopOp.isContinue()) {
            resultConsumer.consume(new ContinueStatement());
        }
    }

    @Override
    public void visit(Call call) {
        String name = call.getName().getResult();

        FunctionCall functionCall = new FunctionCall(name);

        // parse arguments
        if (call.getExpressions().getResult()) {
            List<Expression> arguments = new ArrayList<>();

            functionCall.setArguments(arguments);

            // parse the first argument
            commandQueue.add(new ParseExpression(
                    call.getExpressions().getElement().getExpression(),
                    arguments::add
            ));

            // parse the rest arguments
            for (RestExpressions restExpressions : call.getExpressions().getElement().getRestExpressions()) {
                commandQueue.add(new ParseExpression(
                        restExpressions.getExpression(),
                        arguments::add
                ));
            }
        }

        resultConsumer.consume(functionCall);
    }

    @Override
    public void visit(com.vietage.lang17.lexer.lexeme.ReturnStatement returnLexeme) {
        ReturnStatement returnStatement = new ReturnStatement();

        commandQueue.add(new ParseExpression(
                returnLexeme.getExpression(),
                returnStatement::setExpression
        ));

        resultConsumer.consume(returnStatement);
    }
}
