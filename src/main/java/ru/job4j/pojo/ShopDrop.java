package ru.job4j.pojo;

public class ShopDrop {
    public static void main(String[] args) {
        Product[] products = new Product[3];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            System.out.println(product.getName());
        }
        products[1] = products[2];
        products[2] = null;
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
    }

    public static Product[] delete(Product[] products, int index) {
        for (int i = index; i < products.length; i++) {
            int nextIndex = i + 1;
            Product productNext = null;
            if (nextIndex < products.length) {
                productNext = products[i + 1];
            }
            if (productNext == null) {
                products[i] = null;
                break;
            } else {
                products[i] = productNext;
            }
        }
        return products;
    }
}
