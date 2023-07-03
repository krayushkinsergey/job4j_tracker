package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Элемент " + key + " не найден");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] values = {"Элемент1", "Элемент2", "Элемент3"};

        try {
            int findEl = FindEl.indexOf(values, "Элемент2");
            System.out.println("Найденный индекс элемента " + findEl);

            findEl = FindEl.indexOf(values, "Элемент 3");
            System.out.println("Найденный индекс элемента " + findEl);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
