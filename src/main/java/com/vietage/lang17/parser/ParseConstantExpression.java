package com.vietage.lang17.parser;

import com.vietage.lang17.lexer.lexeme.Constant;
import com.vietage.lang17.parser.ast.expression.Expression;

import java.util.Queue;

public class ParseConstantExpression extends ParseCommand
        <Constant, Expression> {

    public ParseConstantExpression(Constant lexeme, ResultConsumer<Expression> resultConsumer) {
        super(lexeme, resultConsumer);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {

    }
}
