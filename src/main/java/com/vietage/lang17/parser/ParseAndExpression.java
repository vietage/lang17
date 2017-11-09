package com.vietage.lang17.parser;

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

    }
}
