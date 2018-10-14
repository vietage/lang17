package com.vietage.lang17.parser.command;

import com.vietage.lang17.lexer.lexeme.RestEqualExpressions;
import com.vietage.lang17.parser.ast.expression.AndExpression;
import com.vietage.lang17.parser.ast.expression.Expression;

import java.util.Queue;

public class ParseAndExpression extends ParseCommand
        <com.vietage.lang17.lexer.lexeme.AndExpression, Expression> {

    public ParseAndExpression(com.vietage.lang17.lexer.lexeme.AndExpression lexeme,
                              ResultConsumer<Expression> resultConsumer) {
        super(lexeme, resultConsumer);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {
        if (lexeme.getRestEqualExpressions().getLexemes().isEmpty()) {
            // one equality expression exist, skip creation of intermediate AndExpression
            commandQueue.add(
                    new ParseEqualityExpression(
                            lexeme.getEqualExpression(),
                            resultConsumer
                    )
            );
        } else {
            // parse several equality expressions and put them into AndExpression
            AndExpression andExpression = new AndExpression(lexeme.getStartPosition());

            // parse the first equality expression
            commandQueue.add(
                    new ParseEqualityExpression(
                            lexeme.getEqualExpression(),
                            andExpression.getExpressions()::add
                    )
            );

            // parse the rest equality expressions
            for (RestEqualExpressions restEqualExpressions : lexeme.getRestEqualExpressions()) {
                commandQueue.add(
                        new ParseEqualityExpression(
                                restEqualExpressions.getEqualExpression(),
                                andExpression.getExpressions()::add
                        )
                );
            }

            resultConsumer.consume(andExpression);
        }
    }
}
