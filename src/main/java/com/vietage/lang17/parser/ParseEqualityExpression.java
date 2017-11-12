package com.vietage.lang17.parser;

import com.vietage.lang17.lexer.lexeme.EqualExpression;
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

    }
}
