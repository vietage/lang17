package com.vietage.lang17.parser;

import com.vietage.lang17.lexer.lexeme.*;
import com.vietage.lang17.parser.ast.statement.Statement;

import java.util.Queue;

public class ParseStatements extends ParseCommand
        <com.vietage.lang17.lexer.lexeme.Block, Statement>
        implements com.vietage.lang17.lexer.lexeme.Statement.Visitor {

    public ParseStatements(Block lexeme, ParseAction<Statement> action) {
        super(lexeme, action);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {
        for (StatementAndWhitespace statementAndWhitespace : lexeme.getStatements()) {
            statementAndWhitespace.getStatementChoice().getStatement().accept(this);
        }
    }

    @Override
    public void visit(VarDefinition varDefinition) {

    }

    @Override
    public void visit(Assignment assignment) {

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
