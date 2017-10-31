package com.vietage.lang17.lexer;

import com.vietage.lang17.lexer.lexeme.Element;

import java.util.Deque;
import java.util.LinkedList;

public class Context {

    private final SourceReader sourceReader;
    private final Deque<Element> stack = new LinkedList<>();
    private boolean lastResult;

    public Context(SourceReader sourceReader) {
        this.sourceReader = sourceReader;
    }

    public SourceReader getSourceReader() {
        return sourceReader;
    }

    public void enter(Element element) {
        element.setStartPosition(sourceReader.getPosition());
        stack.push(element);
    }

    public Element current() {
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
