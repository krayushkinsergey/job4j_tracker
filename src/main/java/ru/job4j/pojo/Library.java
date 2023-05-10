package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        Book java8 = new Book("Java 8", 625);
        books[0] = java8;

        Book profLibrJava = new Book("Библиотека профессионала Java", 783);
        books[1] = profLibrJava;

        Book hfJava = new Book("Head First Java", 1232);
        books[2] = hfJava;

        Book cleanCode = new Book("Clean code", 933);
        books[3] = cleanCode;

        outBooks(books);
        System.out.println();

        System.out.println("Меняем местами первую и чпетвертую книгу");
        swapBooks(books, 1, 4);
        outBooks(books);
        System.out.println();

        System.out.println("выводом книг с именем \"Clean code\"");
        outBooks(books, "Clean code");
    }

    private static void swapBooks(Book[] books, int first, int second) {
        Book tmp = books[first - 1];
        books[first - 1] = books[second - 1];
        books[second - 1] = tmp;
    }

    private static void outBook(Book book) {
        System.out.println("Книга \"" + book.getName() + "\""
                + ", количество страниц " + book.getNumberPages() + ".");
    }

    private static void outBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            outBook(books[i]);
        }
    }

    private static void outBooks(Book[] books, String filter) {
        for (int i = 0; i < books.length; i++) {
            if (filter.equals(books[i].getName())) {
                outBook(books[i]);
            }
        }
    }
}
