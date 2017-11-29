package com.vietage.lang17.lexer;

import com.vietage.lang17.lexer.lexeme.Lexeme;

import java.util.Deque;
import java.util.LinkedList;

public class Context {

    private final SourceReader sourceReader;
    private final Deque<Lexeme> stack = new LinkedList<>();
    private boolean lastResult;

    public Context(SourceReader sourceReader) {
        this.sourceReader = sourceReader;
    }

    public SourceReader getSourceReader() {
        return sourceReader;
    }

    public void enter(Lexeme lexeme) {
        lexeme.setStartPosition(sourceReader.getPosition());
        stack.push(lexeme);
    }

    public Lexeme current() {
        return stack.peek();
    }

    public void exit() {
        stack.poll();
    }

    public boolean getLastResult() {
        return lastResult;
    }

    public void setLastResult(boolean lastResult) {
        this.lastResult = lastResult;
    }
}
