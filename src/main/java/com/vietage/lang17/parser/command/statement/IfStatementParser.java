package com.vietage.lang17.parser.command.statement;

import com.vietage.lang17.parser.ast.statement.IfStatement;
import com.vietage.lang17.parser.command.ParseCommand;
import com.vietage.lang17.parser.command.expression.ParseExpression;

import java.util.ArrayList;
import java.util.Queue;

class IfStatementParser {

    IfStatement parse(com.vietage.lang17.lexer.lexeme.IfStatement ifLexeme, Queue<ParseCommand> commandQueue) {
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
        return ifStatement;
    }
}
