package ru.job4j.poly;

public interface Transport {
    void drive();

    void passengers(int numberPassengers);

    float refuel(float fuelQuantity);
}
