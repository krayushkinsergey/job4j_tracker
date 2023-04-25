package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int a) {
        return a - x;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        return sum(a) + multiply(a) + minus(a) + divide(a);
    }

    public static void main(String[] args) {
        int rsl = sum(5);
        System.out.println("Method sum " + rsl);

        Calculator calculator = new Calculator();
        rsl = calculator.multiply(5);
        System.out.println("Method multiply " + rsl);

        rsl = minus(5);
        System.out.println("Method minus " + rsl);

        rsl = calculator.divide(5);
        System.out.println("Method divide " + rsl);

        rsl = calculator.sumAllOperation(5);
        System.out.println("Method sumAllOperation " + rsl);
    }
}
