package com.vietage.lang17.parser.command.expression;

import com.vietage.lang17.lexer.lexeme.Call;
import com.vietage.lang17.parser.ast.expression.Expression;
import com.vietage.lang17.parser.command.ParseCommand;
import com.vietage.lang17.parser.command.ParseInvocation;
import com.vietage.lang17.parser.command.ResultConsumer;

import java.util.Queue;

public class ParseFunctionCall extends ParseCommand<Call, Expression> {

    public ParseFunctionCall(Call lexeme,
                             ResultConsumer<Expression> resultConsumer) {
        super(lexeme, resultConsumer);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {
        resultConsumer.consume(new ParseInvocation().parse(lexeme, commandQueue));
    }
}
