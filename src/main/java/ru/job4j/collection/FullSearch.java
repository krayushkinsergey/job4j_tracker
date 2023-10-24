package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {
    public Set<String> extractNumber(List<Task> tasks) {
        Set<String> uniqTasks = new HashSet<>();
        for (Task task : tasks) {
            uniqTasks.add(task.getNumber());
        }
        return uniqTasks;
    }
}
