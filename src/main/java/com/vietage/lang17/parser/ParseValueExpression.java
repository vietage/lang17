package com.vietage.lang17.parser;

import com.vietage.lang17.lexer.lexeme.ValueExpression;
import com.vietage.lang17.parser.ast.expression.Expression;

import java.util.Queue;

public class ParseValueExpression extends ParseCommand
        <ValueExpression, Expression> {

    public ParseValueExpression(ValueExpression lexeme,
                                ResultConsumer<Expression> resultConsumer) {
        super(lexeme, resultConsumer);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {

    }
}
