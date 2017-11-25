package com.vietage.lang17.parser;

import com.vietage.lang17.lexer.lexeme.MulExpression;
import com.vietage.lang17.lexer.lexeme.RestUnaryExpressions;
import com.vietage.lang17.lexer.lexeme.UnaryExpression;
import com.vietage.lang17.parser.ast.expression.Expression;
import com.vietage.lang17.parser.ast.expression.MultiplicationExpression;
import com.vietage.lang17.parser.ast.expression.MultiplicationOperator;

import java.util.Iterator;
import java.util.Queue;

public class ParseMultiplicationExpression extends ParseCommand
        <MulExpression, Expression> {

    public ParseMultiplicationExpression(MulExpression lexeme,
                                         ResultConsumer<Expression> resultConsumer) {
        super(lexeme, resultConsumer);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {
        if (lexeme.getRestUnaryExpressions().getElements().isEmpty()) {
            // no multiplications exist, just parse the next level
            commandQueue.add(
                    new ParseUnaryExpression(
                            lexeme.getUnaryExpression(),
                            resultConsumer
                    )
            );
        } else {
            UnaryExpression firstOperand = lexeme.getUnaryExpression();
            Iterator<RestUnaryExpressions> restOperands = lexeme.getRestUnaryExpressions().getElements().iterator();

            // parse first multiplication
            MultiplicationExpression multiplication = parseFirstMultiplication(
                    commandQueue, firstOperand, restOperands);

            // parse the rest multiplications
            while (restOperands.hasNext()) {
                RestUnaryExpressions next = restOperands.next();

                MultiplicationOperator operator = next.getMulKeyword().getMultiplicationOperator();
                UnaryExpression rightOperand = next.getUnaryExpression();

                MultiplicationExpression multiplicationExpression = new MultiplicationExpression(operator);

                // previously parsed multiplication expression goes to the left expression
                multiplicationExpression.setLeftExpression(multiplication);

                commandQueue.add(
                        new ParseUnaryExpression(
                                rightOperand,
                                multiplicationExpression::setRightExpression
                        )
                );

                multiplication = multiplicationExpression;
            }

            resultConsumer.consume(multiplication);
        }
    }

    private MultiplicationExpression parseFirstMultiplication(Queue<ParseCommand> commandQueue,
                                                              UnaryExpression leftOperand,
                                                              Iterator<RestUnaryExpressions> restOperands) {
        RestUnaryExpressions next = restOperands.next();

        MultiplicationOperator operator = next.getMulKeyword().getMultiplicationOperator();
        UnaryExpression rightOperand = next.getUnaryExpression();

        MultiplicationExpression multiplicationExpression = new MultiplicationExpression(operator);

        commandQueue.add(
                new ParseUnaryExpression(
                        leftOperand,
                        multiplicationExpression::setLeftExpression
                )
        );
        commandQueue.add(
                new ParseUnaryExpression(
                        rightOperand,
                        multiplicationExpression::setRightExpression
                )
        );

        return multiplicationExpression;
    }
}
