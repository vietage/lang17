package com.vietage.lang17.parser.command;

import com.vietage.lang17.lexer.lexeme.Call;
import com.vietage.lang17.lexer.lexeme.RestExpressions;
import com.vietage.lang17.parser.ast.expression.Expression;
import com.vietage.lang17.parser.ast.expression.FunctionCall;
import com.vietage.lang17.parser.command.expression.ParseExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ParseInvocation {

    public FunctionCall parse(Call call, Queue<ParseCommand> commandQueue) {
        FunctionCall functionCall = new FunctionCall(call.getName().getResult(), call.getStartPosition());

        if (call.getExpressions().getResult()) {
            List<Expression> arguments = new ArrayList<>();

            // parse the first argument expression
            commandQueue.add(
                    new ParseExpression(
                            call.getExpressions().getLexeme().getExpression(),
                            arguments::add
                    )
            );

            // parse the rest argument expressions
            for (RestExpressions restExpressions : call.getExpressions().getLexeme().getRestExpressions()) {
                commandQueue.add(
                        new ParseExpression(
                                restExpressions.getExpression(),
                                arguments::add
                        )
                );
            }

            functionCall.setArguments(arguments);
        }

        return functionCall;
    }
}
