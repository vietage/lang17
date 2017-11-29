package com.vietage.lang17.parser.command;

import com.vietage.lang17.lexer.lexeme.Lexeme;
import com.vietage.lang17.parser.ast.ASTElement;

import java.util.Queue;

public abstract class ParseCommand<L extends Lexeme, A extends ASTElement> {

    protected final L lexeme;
    protected final ResultConsumer<A> resultConsumer;

    protected ParseCommand(L lexeme, ResultConsumer<A> resultConsumer) {
        this.lexeme = lexeme;
        this.resultConsumer = resultConsumer;
    }

    public abstract void parse(Queue<ParseCommand> commandQueue);

    public ResultConsumer<A> getResultConsumer() {
        return resultConsumer;
    }
}
