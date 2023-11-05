package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemAscByNameTest {
    @Test
    public void whenSortItemFail() {
        List<Item> items = Arrays.asList(
                new Item(1, "Babb"),
                new Item(2, "Asdf"),
                new Item(3, "Rtyu"),
                new Item(4, "Fghj")
        );

        List<Item> expected = Arrays.asList(
                new Item(2, "Asdf"),
                new Item(1, "Babb"),
                new Item(3, "Rtyu"),
                new Item(4, "Fghj")
        );

        items.sort(new ItemAscByName());
        assertThat(items).isNotEqualTo(expected);
    }

    @Test
    public void whenSortItemSuccess() {
        List<Item> items = Arrays.asList(
                new Item(1, "Babb"),
                new Item(2, "Asdf"),
                new Item(3, "Rtyu"),
                new Item(4, "Fghj")
        );

        List<Item> expected = Arrays.asList(
                new Item(2, "Asdf"),
                new Item(1, "Babb"),
                new Item(4, "Fghj"),
                new Item(3, "Rtyu")
        );

        Collections.sort(items, new ItemAscByName());
        assertThat(items.toArray()).isEqualTo(expected.toArray());
    }
}
