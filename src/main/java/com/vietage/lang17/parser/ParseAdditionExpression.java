package com.vietage.lang17.parser;

import com.vietage.lang17.lexer.lexeme.AddExpression;
import com.vietage.lang17.lexer.lexeme.MulExpression;
import com.vietage.lang17.lexer.lexeme.RestMulExpressions;
import com.vietage.lang17.parser.ast.expression.AdditionExpression;
import com.vietage.lang17.parser.ast.expression.AdditionOperator;
import com.vietage.lang17.parser.ast.expression.Expression;

import java.util.Iterator;
import java.util.Queue;

public class ParseAdditionExpression extends ParseCommand
        <AddExpression, Expression> {

    public ParseAdditionExpression(AddExpression lexeme,
                                   ResultConsumer<Expression> resultConsumer) {
        super(lexeme, resultConsumer);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {
        if (lexeme.getRestMulExpressions().getElements().isEmpty()) {
            // no additions exist, just parse the next level
            commandQueue.add(
                    new ParseMultiplicationExpression(
                            lexeme.getMulExpression(),
                            resultConsumer
                    )
            );
        } else {
            MulExpression firstOperand = lexeme.getMulExpression();
            Iterator<RestMulExpressions> restOperands = lexeme.getRestMulExpressions().getElements().iterator();

            // parse first addition
            AdditionExpression addition = parseFirstAddition(commandQueue, firstOperand, restOperands);

            // parse the rest additions
            while (restOperands.hasNext()) {
                RestMulExpressions next = restOperands.next();

                AdditionOperator operator = next.getAddKeyword().getAdditionOperator();
                MulExpression rightOperand = next.getMulExpression();

                AdditionExpression additionExpression = new AdditionExpression(operator);

                // previously parsed addition expression goes to the left expression
                additionExpression.setLeftExpression(addition);

                commandQueue.add(
                        new ParseMultiplicationExpression(
                                rightOperand,
                                additionExpression::setRightExpression
                        )
                );

                addition = additionExpression;
            }

            resultConsumer.consume(addition);
        }
    }

    private AdditionExpression parseFirstAddition(Queue<ParseCommand> commandQueue,
                                                  MulExpression leftOperand,
                                                  Iterator<RestMulExpressions> restOperands) {
        RestMulExpressions next = restOperands.next();

        AdditionOperator operator = next.getAddKeyword().getAdditionOperator();
        MulExpression rightOperand = next.getMulExpression();

        AdditionExpression additionExpression = new AdditionExpression(operator);

        commandQueue.add(
                new ParseMultiplicationExpression(
                        leftOperand,
                        additionExpression::setLeftExpression
                )
        );
        commandQueue.add(
                new ParseMultiplicationExpression(
                        rightOperand,
                        additionExpression::setRightExpression
                )
        );

        return additionExpression;
    }
}
