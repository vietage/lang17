package com.vietage.lang17.parser.command;

import com.vietage.lang17.lexer.lexeme.Call;
import com.vietage.lang17.lexer.lexeme.RestExpressions;
import com.vietage.lang17.parser.ast.expression.Expression;
import com.vietage.lang17.parser.ast.expression.FunctionCall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class ParseFunctionCall extends ParseCommand
        <Call, Expression> {

    public ParseFunctionCall(Call lexeme,
                             ResultConsumer<Expression> resultConsumer) {
        super(lexeme, resultConsumer);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {
        FunctionCall functionCall = new FunctionCall(lexeme.getName().getResult(), lexeme.getStartPosition());

        if (lexeme.getExpressions().getResult()) {
            List<Expression> arguments = new ArrayList<>();

            // parse the first argument expression
            commandQueue.add(
                    new ParseExpression(
                            lexeme.getExpressions().getLexeme().getExpression(),
                            arguments::add
                    )
            );

            // parse the rest argument expressions
            for (RestExpressions restExpressions : lexeme.getExpressions().getLexeme().getRestExpressions()) {
                commandQueue.add(
                        new ParseExpression(
                                restExpressions.getExpression(),
                                arguments::add
                        )
                );
            }

            functionCall.setArguments(arguments);
        } else {
            // no arguments exist
            functionCall.setArguments(Collections.emptyList());
        }

        resultConsumer.consume(functionCall);
    }
}
