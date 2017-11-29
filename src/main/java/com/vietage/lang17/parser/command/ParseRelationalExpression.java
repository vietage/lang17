package com.vietage.lang17.parser.command;

import com.vietage.lang17.lexer.lexeme.RelativeExpression;
import com.vietage.lang17.parser.ast.expression.Expression;
import com.vietage.lang17.parser.ast.expression.RelationalExpression;
import com.vietage.lang17.parser.ast.expression.RelationalOperator;

import java.util.Queue;

public class ParseRelationalExpression extends ParseCommand<RelativeExpression, Expression> {

    public ParseRelationalExpression(RelativeExpression lexeme,
                                     ResultConsumer<Expression> resultConsumer) {
        super(lexeme, resultConsumer);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {
        if (!lexeme.getRightAddExpression().getResult()) {
            // no right hand expression exists, just parse the left one
            commandQueue.add(
                    new ParseAdditionExpression(
                            lexeme.getAddExpression(),
                            resultConsumer
                    )
            );
        } else {
            RelationalOperator relationalOperator = lexeme.getRightAddExpression()
                    .getLexeme().getRelativeOp().getRelationalOperator();

            RelationalExpression relationalExpression = new RelationalExpression(relationalOperator);

            // parse left hand expression
            commandQueue.add(
                    new ParseAdditionExpression(
                            lexeme.getAddExpression(),
                            relationalExpression::setLeftExpression
                    )
            );

            // parse right hand expression
            commandQueue.add(
                    new ParseAdditionExpression(
                            lexeme.getRightAddExpression().getLexeme().getAddExpression(),
                            relationalExpression::setRightExpression
                    )
            );

            resultConsumer.consume(relationalExpression);
        }
    }
}
