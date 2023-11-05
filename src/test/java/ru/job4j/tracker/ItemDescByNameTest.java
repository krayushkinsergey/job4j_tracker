package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemDescByNameTest {
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

        items.sort(new ItemDescByName());
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
                new Item(3, "Rtyu"),
                new Item(4, "Fghj"),
                new Item(1, "Babb"),
                new Item(2, "Asdf")
        );

        Collections.sort(items, new ItemDescByName());
        assertThat(items.toArray()).isEqualTo(expected.toArray());
    }
}
