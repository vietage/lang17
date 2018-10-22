package com.vietage.lang17.parser.command.expression;

import com.vietage.lang17.lexer.lexeme.*;
import com.vietage.lang17.parser.ast.expression.Expression;
import com.vietage.lang17.parser.command.ParseCommand;
import com.vietage.lang17.parser.command.ResultConsumer;

import java.util.Queue;

public class ParseValueExpression extends ParseCommand<ValueExpression, Expression>
        implements ValueExpressionLexeme.Visitor {

    private Queue<ParseCommand> commandQueue;

    public ParseValueExpression(ValueExpression lexeme,
                                ResultConsumer<Expression> resultConsumer) {
        super(lexeme, resultConsumer);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {
        this.commandQueue = commandQueue;

        lexeme.getValueExpressionElement().accept(this);
    }

    @Override
    public void visit(BracketsExpression bracketsExpression) {
        commandQueue.add(
                new ParseExpression(
                        bracketsExpression.getExpression(),
                        resultConsumer
                )
        );
    }

    @Override
    public void visit(Constant constant) {
        commandQueue.add(
                new ParseConstantExpression(
                        constant,
                        resultConsumer
                )
        );
    }

    @Override
    public void visit(VarAccess varAccess) {
        commandQueue.add(
                new ParseVariableRead(
                        varAccess,
                        resultConsumer
                )
        );
    }

    @Override
    public void visit(NewArray newArray) {
        commandQueue.add(
                new ParseArrayAllocation(
                        newArray,
                        resultConsumer
                )
        );
    }

    @Override
    public void visit(Call call) {
        commandQueue.add(
                new ParseFunctionCall(
                        call,
                        resultConsumer
                )
        );
    }
}
