package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class CombinComparatorTest {
    @Test
    public void whenNameAndPriorityFirstLessSecond() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Abs task", 0),
                new Job("Abs task", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenNameAndPriorityFirstEqualsSecond() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Abs task", 1),
                new Job("Abs task", 1)
        );
        assertThat(rsl).isEqualTo(0);
    }

    @Test
    public void whenNameAndPriorityFirstGreaterSecond() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Abs task", 1),
                new Job("Abs task", 0)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenPriorityAndDescNameFirstLessSecond() {
        Comparator<Job> cmp = new JobAscByPriority().thenComparing(new JobDescByName());
        int rsl = cmp.compare(
                new Job("Cdf task", 0),
                new Job("Abs task", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenPriorityAndDescNameFirstEqualsSecond() {
        Comparator<Job> cmp = new JobAscByPriority().thenComparing(new JobDescByName());
        int rsl = cmp.compare(
                new Job("Abs task", 1),
                new Job("Abs task", 1)
        );
        assertThat(rsl).isEqualTo(0);
    }

    @Test
    public void whenPriorityAndDescNameFirstGreaterSecond() {
        Comparator<Job> cmp = new JobAscByPriority().thenComparing(new JobDescByName());
        int rsl = cmp.compare(
                new Job("Abs task", 1),
                new Job("Cdf task", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}
