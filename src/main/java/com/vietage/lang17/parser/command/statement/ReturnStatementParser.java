package com.vietage.lang17.parser.command.statement;

import com.vietage.lang17.parser.ast.statement.ReturnStatement;
import com.vietage.lang17.parser.command.ParseCommand;
import com.vietage.lang17.parser.command.expression.ParseExpression;

import java.util.Queue;

class ReturnStatementParser {

    ReturnStatement parse(com.vietage.lang17.lexer.lexeme.ReturnStatement returnLexeme,
                          Queue<ParseCommand> commandQueue) {
        ReturnStatement returnStatement = new ReturnStatement(returnLexeme.getStartPosition());

        commandQueue.add(
                new ParseExpression(
                        returnLexeme.getExpression(),
                        returnStatement::setExpression
                )
        );
        return returnStatement;
    }
}
