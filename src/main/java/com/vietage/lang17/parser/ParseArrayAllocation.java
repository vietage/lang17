package com.vietage.lang17.parser;

import com.vietage.lang17.lexer.lexeme.NewArray;
import com.vietage.lang17.parser.ast.Type;
import com.vietage.lang17.parser.ast.expression.ArrayAllocation;
import com.vietage.lang17.parser.ast.expression.Expression;

import java.util.Queue;

public class ParseArrayAllocation extends ParseCommand
        <NewArray, Expression> {

    public ParseArrayAllocation(NewArray lexeme,
                                ResultConsumer<Expression> resultConsumer) {
        super(lexeme, resultConsumer);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {
        Type type = Type.getArrayType(lexeme.getBasicType().getType());

        ArrayAllocation arrayAllocation = new ArrayAllocation(type);

        commandQueue.add(
                new ParseExpression(
                        lexeme.getIndexExpression().getExpression(),
                        arrayAllocation::setSizeExpression
                )
        );

        resultConsumer.consume(arrayAllocation);
    }
}
