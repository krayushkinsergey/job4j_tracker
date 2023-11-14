package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        String[] leftArray = left.split("\\.");
        String[] rightArray = right.split("\\.");
        int leftInt = Integer.parseInt(leftArray[0]);
        int rightInt = Integer.parseInt(rightArray[0]);
        rsl = Integer.compare(leftInt, rightInt);
        return rsl != 0 ? rsl : leftArray[1].compareTo(rightArray[1]);
    }
}
