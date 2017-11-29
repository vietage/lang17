package com.vietage.lang17.parser.command;

import com.vietage.lang17.lexer.lexeme.BracketsExpression;
import com.vietage.lang17.lexer.lexeme.Call;
import com.vietage.lang17.lexer.lexeme.Constant;
import com.vietage.lang17.lexer.lexeme.NewArray;
import com.vietage.lang17.lexer.lexeme.ValueExpression;
import com.vietage.lang17.lexer.lexeme.ValueExpressionLexeme;
import com.vietage.lang17.lexer.lexeme.VarAccess;
import com.vietage.lang17.parser.ast.expression.Expression;

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
