package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Поехали");
    }

    @Override
    public void passengers(int numberPassengers) {
        System.out.println("Количество пассажиров " + numberPassengers);
    }

    @Override
    public float refuel(float fuelQuantity) {
        System.out.printf("Заправить %.2f л \n", fuelQuantity);
        float price = 51.87f;
        System.out.println("Цена " + price);
        return price;
    }

    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.drive();
        bus.passengers(10);
        bus.refuel(35.56f);
    }
}
