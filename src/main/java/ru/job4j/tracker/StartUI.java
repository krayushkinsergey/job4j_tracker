package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime dateTime = item.getCreated();
        System.out.println("Дата и время " + dateTime);
        String dateTimeFormat = dateTime.format(formatter);
        System.out.println("Отформатированная дата и время " + dateTimeFormat);
    }
}
