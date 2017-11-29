package com.vietage.lang17.parser.command;

import com.vietage.lang17.lexer.lexeme.RestAndExpressions;
import com.vietage.lang17.parser.ast.expression.Expression;
import com.vietage.lang17.parser.ast.expression.OrExpression;

import java.util.Queue;

public class ParseExpression extends ParseCommand
        <com.vietage.lang17.lexer.lexeme.Expression, Expression> {

    public ParseExpression(com.vietage.lang17.lexer.lexeme.Expression lexeme,
                           ResultConsumer<Expression> resultConsumer) {
        super(lexeme, resultConsumer);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {
        if (lexeme.getRestAndExpressions().getElements().isEmpty()) {
            // just one expression exists, do not create intermediate AndExpression
            commandQueue.add(new ParseAndExpression(
                    lexeme.getAndExpression(),
                    resultConsumer
            ));
        } else {
            // several expressions exist, parse them all
            OrExpression orExpression = new OrExpression();

            // parse the first and expression
            commandQueue.add(new ParseAndExpression(
                    lexeme.getAndExpression(),
                    orExpression.getExpressions()::add
            ));

            // parse the rest and expressions
            for (RestAndExpressions restAndExpressions : lexeme.getRestAndExpressions()) {
                commandQueue.add(new ParseAndExpression(
                        restAndExpressions.getAndExpression(),
                        orExpression.getExpressions()::add
                ));
            }

            resultConsumer.consume(orExpression);
        }
    }
}
