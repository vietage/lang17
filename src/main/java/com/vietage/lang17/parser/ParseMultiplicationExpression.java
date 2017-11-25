package com.vietage.lang17.parser;

import com.vietage.lang17.lexer.lexeme.MulExpression;
import com.vietage.lang17.parser.ast.expression.Expression;

import java.util.Queue;

public class ParseMultiplicationExpression extends ParseCommand
        <MulExpression, Expression> {

    public ParseMultiplicationExpression(MulExpression lexeme,
                                         ResultConsumer<Expression> resultConsumer) {
        super(lexeme, resultConsumer);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {

    }
}
