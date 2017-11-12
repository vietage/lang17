package com.vietage.lang17.parser;

import com.vietage.lang17.lexer.lexeme.RelativeExpression;
import com.vietage.lang17.parser.ast.expression.Expression;

import java.util.Queue;

public class ParseRelationalExpression extends ParseCommand
        <RelativeExpression, Expression> {

    public ParseRelationalExpression(RelativeExpression lexeme,
                                     ResultConsumer<Expression> resultConsumer) {
        super(lexeme, resultConsumer);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {

    }
}
