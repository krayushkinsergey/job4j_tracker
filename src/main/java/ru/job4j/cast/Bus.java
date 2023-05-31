package ru.job4j.cast;

public class Bus implements Vehicle {
    public static final String TYPE = "Автобус";
    private String model;

    public Bus(String model) {
        this.model = model;
    }

    @Override
    public void move() {
        System.out.println("Автобус едет по дороге");
    }

    @Override
    public String getInfo() {
        return getTypeAndModel(TYPE, model);
    }
}
