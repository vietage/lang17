package com.vietage.lang17.parser;

import com.vietage.lang17.lexer.lexeme.UnaryExpression;
import com.vietage.lang17.parser.ast.expression.Expression;

import java.util.Queue;

public class ParseUnaryExpression extends ParseCommand
        <UnaryExpression, Expression> {

    public ParseUnaryExpression(UnaryExpression lexeme,
                                ResultConsumer<Expression> resultConsumer) {
        super(lexeme, resultConsumer);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {

    }
}
