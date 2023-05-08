package ru.job4j.pojo;

public class Book {
    private String name;
    private int numberPages;

    public Book(String name, int numberPages) {
        this.name = name;
        this.numberPages = numberPages;
    }

    public String getName() {
        return name;
    }

    public int getNumberPages() {
        return numberPages;
    }
}
