package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
//    private final Item[] items = new Item[100];
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
//    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
//        items[size++] = item;
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
//        return Arrays.copyOf(items, size);
        return items;
    }

    public List<Item> findByName(String key) {
//        Item[] findItems = new Item[items.length];
//        int newSize = 0;
//        for (int index = 0; index < size; index++) {
//            if (items[index].getName().equals(key)) {
//                findItems[newSize] = items[index];
//                newSize++;
//            }
//        }
//        return Arrays.copyOf(findItems, newSize);
        List<Item> findItems = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                findItems.add(item);
            }
        }
        return  findItems;
    }

    private int indexOf(int id) {
        int rsl = -1;
//        for (int index = 0; index < size; index++) {
//            if (items[index].getId() == id) {
//                rsl = index;
//                break;
//            }
//        }
        for (int index = 0; index < items.size(); index++) {
            Item item = items.get(index);
            if (item.getId() == id) {
                rsl = index;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
//            items[index] = item;
            items.set(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
//            System.arraycopy(items, index + 1, items, index, size - index - 1);
//            items[size - 1] = null;
//            size--;
            items.remove(index);
        }
        return rsl;
    }
}