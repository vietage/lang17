package com.vietage.lang17.parser.command.statement;

import com.vietage.lang17.lexer.lexeme.*;
import com.vietage.lang17.parser.ast.statement.*;
import com.vietage.lang17.parser.ast.statement.IfStatement;
import com.vietage.lang17.parser.ast.statement.ReturnStatement;
import com.vietage.lang17.parser.ast.statement.WhileLoop;
import com.vietage.lang17.parser.command.ParseCommand;
import com.vietage.lang17.parser.command.ParseInvocation;
import com.vietage.lang17.parser.command.ResultConsumer;
import com.vietage.lang17.parser.command.expression.ParseExpression;

import java.util.ArrayList;
import java.util.Queue;

public class ParseStatements extends ParseCommand<Block, Statement>
        implements StatementChoiceLexeme.Visitor {

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
                varDefinition.getName().getResult(),
                varDefinition.getStartPosition()
        );

        // parse right hand expression
        commandQueue.add(
                new ParseExpression(
                        varDefinition.getExpression(),
                        variableDefinition::setExpression
                )
        );

        resultConsumer.consume(variableDefinition);
    }

    @Override
    public void visit(Assignment assignment) {
        String name = assignment.getVarAccess().getName().getResult();

        VariableAssignment variableAssignment = new VariableAssignment(name, assignment.getStartPosition());

        // parse array index expression
        if (assignment.getVarAccess().getIndexExpression().getResult()) {
            commandQueue.add(
                    new ParseExpression(
                            assignment.getVarAccess().getIndexExpression().getLexeme().getExpression(),
                            variableAssignment::setIndexExpression
                    )
            );
        }

        // parse right hand expression
        commandQueue.add(
                new ParseExpression(
                        assignment.getExpression(),
                        variableAssignment::setExpression
                )
        );

        resultConsumer.consume(variableAssignment);
    }

    @Override
    public void visit(com.vietage.lang17.lexer.lexeme.IfStatement ifLexeme) {
        IfStatement ifStatement = new IfStatement(ifLexeme.getStartPosition());

        // parse condition
        commandQueue.add(
                new ParseExpression(
                        ifLexeme.getBracketsExpression().getExpression(),
                        ifStatement::setCondition
                )
        );

        // parse true branch statements
        commandQueue.add(
                new ParseStatements(
                        ifLexeme.getBlock(),
                        statement -> ifStatement.getTrueStatements().add(statement)
                )
        );

        // parse false branch statements
        if (ifLexeme.getElseBlock().getResult()) {
            ifStatement.setFalseStatements(new ArrayList<>());

            commandQueue.add(
                    new ParseStatements(
                            ifLexeme.getElseBlock().getLexeme().getBlock(),
                            statement -> ifStatement.getFalseStatements().add(statement)
                    )
            );
        }

        resultConsumer.consume(ifStatement);
    }

    @Override
    public void visit(com.vietage.lang17.lexer.lexeme.WhileLoop whileLexeme) {
        WhileLoop whileLoop = new WhileLoop(whileLexeme.getStartPosition());

        // parse condition
        commandQueue.add(
                new ParseExpression(
                        whileLexeme.getBracketsExpression().getExpression(),
                        whileLoop::setCondition
                )
        );

        // parse statements
        commandQueue.add(
                new ParseStatements(
                        whileLexeme.getBlock(),
                        statement -> whileLoop.getStatements().add(statement)
                )
        );

        resultConsumer.consume(whileLoop);
    }

    @Override
    public void visit(LoopOp loopOp) {
        if (loopOp.isBreak()) {
            resultConsumer.consume(new BreakStatement(loopOp.getStartPosition()));
        }
        if (loopOp.isContinue()) {
            resultConsumer.consume(new ContinueStatement(loopOp.getStartPosition()));
        }
    }

    @Override
    public void visit(Call call) {
        resultConsumer.consume(new ParseInvocation().parse(call, commandQueue));
    }

    @Override
    public void visit(com.vietage.lang17.lexer.lexeme.ReturnStatement returnLexeme) {
        ReturnStatement returnStatement = new ReturnStatement(returnLexeme.getStartPosition());

        commandQueue.add(
                new ParseExpression(
                        returnLexeme.getExpression(),
                        returnStatement::setExpression
                )
        );

        resultConsumer.consume(returnStatement);
    }
}
