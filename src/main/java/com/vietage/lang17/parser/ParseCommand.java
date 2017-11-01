package com.vietage.lang17.parser;

import com.vietage.lang17.lexer.lexeme.Element;
import com.vietage.lang17.parser.ast.ASTElement;

import java.util.Queue;

public abstract class ParseCommand<L extends Element, A extends ASTElement> {

    protected final L lexeme;
    protected final ParseAction<A> action;

    protected ParseCommand(L lexeme, ParseAction<A> action) {
        this.lexeme = lexeme;
        this.action = action;
    }

    public abstract void parse(Queue<ParseCommand> commandQueue);

    public ParseAction<A> getAction() {
        return action;
    }
}
