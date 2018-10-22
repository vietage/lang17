package com.vietage.lang17.parser.command.statement;

import com.vietage.lang17.parser.ast.statement.WhileLoop;
import com.vietage.lang17.parser.command.ParseCommand;
import com.vietage.lang17.parser.command.expression.ParseExpression;

import java.util.Queue;

class WhileLoopParser {

    WhileLoop parse(com.vietage.lang17.lexer.lexeme.WhileLoop whileLexeme, Queue<ParseCommand> commandQueue) {
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
        return whileLoop;
    }
}
