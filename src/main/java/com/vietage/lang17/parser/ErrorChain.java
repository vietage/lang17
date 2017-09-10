package com.vietage.lang17.parser;

import com.vietage.lang17.parser.ast.Element;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

public class ErrorChain {

    private final Deque<Element> errorChain = new ArrayDeque<>();

    public void add(Element element) {
        errorChain.push(element);
    }

    public void clear() {
        errorChain.clear();
    }

    public String getErrorMessage() {
        return errorChain.stream()
                .map(o -> o.toString() + " position: " + o.getStartPosition())
                .collect(Collectors.joining("\n"));
    }
}
