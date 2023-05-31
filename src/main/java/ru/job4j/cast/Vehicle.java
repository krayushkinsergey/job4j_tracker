package ru.job4j.cast;

public interface Vehicle {
    void move();

    String getInfo();

    default String getTypeAndModel(String type, String model) {
        return "Транспортное средство типа " + type + " модель " + model;
    }
}
