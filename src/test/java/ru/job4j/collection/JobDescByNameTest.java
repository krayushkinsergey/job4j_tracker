package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

class JobDescByNameTest {
    @Test
    void whenFirstLessSecond() {
        Comparator<Job> cmp = new JobDescByName();
        int rsl = cmp.compare(
                new Job("Cdf task", 0),
                new Job("Abs task", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void whenFirstEqualsSecond() {
        Comparator<Job> cmp = new JobDescByName();
        int rsl = cmp.compare(
                new Job("Abs task", 0),
                new Job("Abs task", 1)
        );
        assertThat(rsl).isEqualTo(0);
    }

    @Test
    void whenFirstGreaterSecond() {
        Comparator<Job> cmp = new JobDescByName();
        int rsl = cmp.compare(
                new Job("Abs task", 0),
                new Job("Cdf task", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}