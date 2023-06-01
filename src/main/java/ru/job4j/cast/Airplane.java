package ru.job4j.cast;

public class Airplane implements Vehicle {
    public static final String TYPE = "Самолет";
    private String model;

    public Airplane(String model) {
        this.model = model;
    }

    @Override
    public void move() {
        System.out.println("Самолет летит по воздуху");
    }

    @Override
    public String getInfo() {
        return getTypeAndModel(TYPE, model);
    }
}
