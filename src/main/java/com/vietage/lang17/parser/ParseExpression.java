package com.vietage.lang17.parser;

import com.vietage.lang17.parser.ast.expression.Expression;

import java.util.Queue;

public class ParseExpression extends ParseCommand
        <com.vietage.lang17.lexer.lexeme.Expression, Expression> {

    public ParseExpression(com.vietage.lang17.lexer.lexeme.Expression lexeme,
                           ResultConsumer<Expression> action) {
        super(lexeme, action);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {

    }
}
