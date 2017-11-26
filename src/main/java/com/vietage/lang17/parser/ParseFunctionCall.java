package com.vietage.lang17.parser;

import com.vietage.lang17.lexer.lexeme.Call;
import com.vietage.lang17.parser.ast.expression.Expression;

import java.util.Queue;

public class ParseFunctionCall extends ParseCommand
        <Call, Expression> {

    public ParseFunctionCall(Call lexeme,
                             ResultConsumer<Expression> resultConsumer) {
        super(lexeme, resultConsumer);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {

    }
}
