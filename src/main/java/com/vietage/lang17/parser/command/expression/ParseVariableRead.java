package com.vietage.lang17.parser.command.expression;

import com.vietage.lang17.lexer.lexeme.VarAccess;
import com.vietage.lang17.parser.ast.expression.ArrayRead;
import com.vietage.lang17.parser.ast.expression.Expression;
import com.vietage.lang17.parser.ast.expression.VariableRead;
import com.vietage.lang17.parser.command.ParseCommand;
import com.vietage.lang17.parser.command.ResultConsumer;

import java.util.Queue;

public class ParseVariableRead extends ParseCommand<VarAccess, Expression> {

    public ParseVariableRead(VarAccess lexeme,
                             ResultConsumer<Expression> resultConsumer) {
        super(lexeme, resultConsumer);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {
        String name = lexeme.getName().getResult();

        if (lexeme.getIndexExpression().getResult()) {
            // parse array read
            ArrayRead arrayRead = new ArrayRead(name, lexeme.getStartPosition());

            commandQueue.add(
                    new ParseExpression(
                            lexeme.getIndexExpression().getLexeme().getExpression(),
                            arrayRead::setIndexExpression
                    )
            );
            resultConsumer.consume(arrayRead);
        } else {
            // parse variable read
            resultConsumer.consume(new VariableRead(name, lexeme.getStartPosition()));
        }

    }
}
