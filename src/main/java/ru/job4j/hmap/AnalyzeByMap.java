package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int score = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                count++;
            }
        }
        return (double) score / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> lists = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int score = 0;
            int count = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                count++;
            }
            lists.add(new Label(pupil.name(), (double) score / count));
        }
        return lists;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> lists = new ArrayList<>();
        Map<String, Integer> maps = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                maps.put(subject.name(), maps.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String name : maps.keySet()) {
            lists.add(new Label(name, (double) maps.get(name) / pupils.size()));
        }
        return lists;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> lists = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            lists.add(new Label(pupil.name(), score));
        }
        lists.sort(Comparator.naturalOrder());
        return lists.get(lists.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> lists = new ArrayList<>();
        Map<String, Integer> maps = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (maps.containsKey(subject.name())) {
                    int newValue = maps.get(subject.name()) + subject.score();
                    maps.put(subject.name(), newValue);
                } else {
                    maps.put(subject.name(), subject.score());
                }
                maps.put(subject.name(), maps.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String name : maps.keySet()) {
            lists.add(new Label(name, maps.get(name)));
        }
        lists.sort(Comparator.naturalOrder());
        return lists.get(lists.size() - 1);
    }
}
