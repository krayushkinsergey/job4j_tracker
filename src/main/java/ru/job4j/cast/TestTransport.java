package ru.job4j.cast;

public class TestTransport {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Airplane("Аэрбас");
        Vehicle vehicle2 = new Airplane("Боинг");
        Vehicle vehicle3 = new Train("Сапсан");
        Vehicle vehicle4 = new Train("Ласточка");
        Vehicle vehicle5 = new Bus("Мерседес");
        Vehicle vehicle6 = new Bus("Хундай");

        Vehicle[] vehicles = {vehicle1, vehicle2, vehicle3, vehicle4, vehicle5, vehicle6};
        for (Vehicle vehicle: vehicles) {
            System.out.println(vehicle.getInfo());
            vehicle.move();
        }
    }
}
