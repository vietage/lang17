package com.vietage.lang17.parser.command;

import com.vietage.lang17.lexer.lexeme.EqualExpression;
import com.vietage.lang17.parser.ast.expression.EqualityExpression;
import com.vietage.lang17.parser.ast.expression.EqualityOperator;
import com.vietage.lang17.parser.ast.expression.Expression;

import java.util.Queue;

public class ParseEqualityExpression extends ParseCommand
        <EqualExpression, Expression> {

    public ParseEqualityExpression(EqualExpression lexeme,
                                   ResultConsumer<Expression> resultConsumer) {
        super(lexeme, resultConsumer);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {
        if (!lexeme.getRightRelativeExpression().getResult()) {
            // no right hand expression exists, just parse the left expression
            commandQueue.add(new ParseRelationalExpression(
                    lexeme.getRelativeExpression(),
                    resultConsumer
            ));
        } else {
            EqualityOperator equalityOperator = lexeme.getRightRelativeExpression()
                    .getLexeme().getEqualOp().getEqualityOperator();

            EqualityExpression equalityExpression = new EqualityExpression(equalityOperator);

            // parse left hand expression
            commandQueue.add(new ParseRelationalExpression(
                    lexeme.getRelativeExpression(),
                    equalityExpression::setLeftExpression
            ));

            // parse right hand expression
            commandQueue.add(new ParseRelationalExpression(
                    lexeme.getRightRelativeExpression().getLexeme().getRelativeExpression(),
                    equalityExpression::setRightExpression
            ));

            resultConsumer.consume(equalityExpression);
        }
    }
}
