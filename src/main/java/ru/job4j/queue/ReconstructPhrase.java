package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder str = new StringBuilder();
        int to = evenElements.size() - 1;
        for (int i = 0; i <= to; i++) {
            Character symbol =  evenElements.poll();
            if (i % 2 == 0) {
                str.append(symbol);
            }
        }
        return str.toString();
    }

    private String getDescendingElements() {
        StringBuilder str = new StringBuilder();
        int to = descendingElements.size() - 1;
        for (int i = 0; i <= to; i++) {
            str.append(descendingElements.pollLast());
        }
        return str.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
