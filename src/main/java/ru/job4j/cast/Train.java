package ru.job4j.cast;

public class Train implements Vehicle {
    public static final String TYPE = "Поезд";
    private String model;

    public Train(String model) {
        this.model = model;
    }

    @Override
    public void move() {
        System.out.println("Поезд едит по рельсам");
    }

    @Override
    public String getInfo() {
        return getTypeAndModel(TYPE, model);
    }
}
