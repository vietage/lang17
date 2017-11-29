package com.vietage.lang17.parser.command;

import com.vietage.lang17.lexer.lexeme.Constant;
import com.vietage.lang17.lexer.lexeme.ConstantElement;
import com.vietage.lang17.lexer.lexeme.NumberConstant;
import com.vietage.lang17.parser.ast.expression.BooleanConstant;
import com.vietage.lang17.parser.ast.expression.Expression;
import com.vietage.lang17.parser.ast.expression.FloatConstant;
import com.vietage.lang17.parser.ast.expression.IntegerConstant;
import com.vietage.lang17.parser.ast.expression.StringConstant;

import java.util.Queue;

public class ParseConstantExpression extends ParseCommand<Constant, Expression>
        implements ConstantElement.Visitor {

    public ParseConstantExpression(Constant lexeme,
                                   ResultConsumer<Expression> resultConsumer) {
        super(lexeme, resultConsumer);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {
        lexeme.getConstantElement().accept(this);
    }

    @Override
    public void visit(NumberConstant numberConstant) {
        if (numberConstant.getFractionPart().getResult()) {
            // parse float constant
            long integerPart = numberConstant.getIntegerPart().getResult();
            long fractionPart = numberConstant.getFractionPart().getElement().getIntegerPart().getResult();

            double value = Double.valueOf(integerPart + "." + fractionPart);

            resultConsumer.consume(
                    new FloatConstant(value)
            );
        } else {
            // parse integer constant
            resultConsumer.consume(
                    new IntegerConstant(numberConstant.getIntegerPart().getResult())
            );
        }
    }

    @Override
    public void visit(com.vietage.lang17.lexer.lexeme.StringConstant stringConstant) {
        resultConsumer.consume(
                new StringConstant(stringConstant.getStringToken().getResult())
        );
    }

    @Override
    public void visit(com.vietage.lang17.lexer.lexeme.BooleanConstant booleanConstant) {
        resultConsumer.consume(
                new BooleanConstant(booleanConstant.getResult())
        );
    }
}
