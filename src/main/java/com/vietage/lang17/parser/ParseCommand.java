package com.vietage.lang17.parser;

import com.vietage.lang17.lexer.lexeme.Element;
import com.vietage.lang17.parser.ast.ASTElement;

import java.util.Queue;

public abstract class ParseCommand<L extends Element, A extends ASTElement> {

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
