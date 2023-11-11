package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

class JobDescByPriorityTest {
    @Test
    void whenFirstLessSecond() {
        Comparator<Job> cmp = new JobDescByPriority();
        int rsl = cmp.compare(
                new Job("Cdf task", 1),
                new Job("Abs task", 0)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void whenFirstEqualsSecond() {
        Comparator<Job> cmp = new JobDescByPriority();
        int rsl = cmp.compare(
                new Job("Cdf task", 1),
                new Job("Abs task", 1)
        );
        assertThat(rsl).isEqualTo(0);
    }

    @Test
    void whenFirstGreaterSecond() {
        Comparator<Job> cmp = new JobDescByPriority();
        int rsl = cmp.compare(
                new Job("Abs task", 1),
                new Job("Cdf task", 2)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}