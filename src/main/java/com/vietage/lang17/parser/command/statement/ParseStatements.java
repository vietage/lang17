package com.vietage.lang17.parser.command.statement;

import com.vietage.lang17.lexer.lexeme.*;
import com.vietage.lang17.parser.ast.statement.Statement;
import com.vietage.lang17.parser.command.ParseCommand;
import com.vietage.lang17.parser.command.ParseInvocation;
import com.vietage.lang17.parser.command.ResultConsumer;

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
        resultConsumer.consume(new VariableDefinitionParser().parse(varDefinition, commandQueue));
    }

    @Override
    public void visit(Assignment assignment) {
        resultConsumer.consume(new VariableAssignmentParser().parse(assignment, commandQueue));
    }

    @Override
    public void visit(IfStatement ifLexeme) {
        resultConsumer.consume(new IfStatementParser().parse(ifLexeme, commandQueue));
    }

    @Override
    public void visit(WhileLoop whileLexeme) {
        resultConsumer.consume(new WhileLoopParser().parse(whileLexeme, commandQueue));
    }

    @Override
    public void visit(LoopOp loopOp) {
        resultConsumer.consume(new LoopStatementParser().parse(loopOp));
    }

    @Override
    public void visit(Call call) {
        resultConsumer.consume(new ParseInvocation().parse(call, commandQueue));
    }

    @Override
    public void visit(ReturnStatement returnLexeme) {
        resultConsumer.consume(new ReturnStatementParser().parse(returnLexeme, commandQueue));
    }
}
