package com.vietage.lang17.parser.command.expression;

import com.vietage.lang17.parser.ast.expression.Expression;
import com.vietage.lang17.parser.ast.expression.UnaryExpression;
import com.vietage.lang17.parser.ast.expression.UnaryOperator;
import com.vietage.lang17.parser.command.ParseCommand;
import com.vietage.lang17.parser.command.ResultConsumer;

import java.util.Queue;

public class ParseUnaryExpression extends ParseCommand<com.vietage.lang17.lexer.lexeme.UnaryExpression, Expression> {

    public ParseUnaryExpression(com.vietage.lang17.lexer.lexeme.UnaryExpression lexeme,
                                ResultConsumer<Expression> resultConsumer) {
        super(lexeme, resultConsumer);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {
        if (!lexeme.getUnaryKeyword().getResult()) {
            // no unary operator exist, just parse the next level
            commandQueue.add(
                    new ParseValueExpression(
                            lexeme.getValueExpression(),
                            resultConsumer
                    )
            );
        } else {
            UnaryOperator operator = lexeme.getUnaryKeyword().getLexeme().getUnaryOperator();

            UnaryExpression unaryExpression = new UnaryExpression(operator, lexeme.getStartPosition());

            commandQueue.add(
                    new ParseValueExpression(
                            lexeme.getValueExpression(),
                            unaryExpression::setExpression
                    )
            );

            resultConsumer.consume(unaryExpression);
        }
    }
}
