package com.vietage.lang17.parser;

import com.vietage.lang17.lexer.lexeme.AddExpression;
import com.vietage.lang17.parser.ast.expression.Expression;

import java.util.Queue;

public class ParseAdditionExpression extends ParseCommand
        <AddExpression, Expression> {

    public ParseAdditionExpression(AddExpression lexeme,
                                   ResultConsumer<Expression> resultConsumer) {
        super(lexeme, resultConsumer);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {

    }
}
