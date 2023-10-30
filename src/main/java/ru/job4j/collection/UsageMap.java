package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("krayushkin.sergey@gmail.com", "Краюшкин Сергей");
        map.put("krayushkin.sergey@gmail.com", "Краюшкин Сергей Александрович");
        map.put("test@gmail.com", "test_google");
        map.put("test@yandex.ru", "test_yandex");
        for (String key: map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
