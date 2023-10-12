package ru.job4j.assertj.primitives;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ModelTest {
    @Test
    public void checkBoolean() {
        Model model = new Model(1, 5.255d, "name", true);
        boolean rsl = model.isCondition();
        assertThat(rsl).isTrue();
    }

    @Test
    public void checkStringChain() {
        Model model = new Model(1, 5.225d, "I am learning java", true);
        String rsl = model.getLine();
        assertThat(rsl).isNotNull()
                .isNotEmpty()
                .isNotBlank()
                .containsIgnoringCase("java")
                .contains("am", "java")
                .doesNotContain("javascript")
                .startsWith("I am")
                .startsWithIgnoringCase("i")
                .endsWith("java")
                .isEqualTo("I am learning java");
    }

    @Test
    public void checkInt() {
        Model model = new Model(2, 5.2d, "name", true);
        int rsl = model.getTop();
        assertThat(rsl).isNotZero()
                .isPositive()
                .isEven()
                .isGreaterThan(1)
                .isLessThan(3)
                .isEqualTo(2);
    }

    @Test
    public void checkDoubleChain() {
        Model model = new Model(1, 5.255d, "name", true);
        double rsl = model.getNum();
        assertThat(rsl).isEqualTo(5.26d, withPrecision(0.006d))
                .isCloseTo(5.25d, withPrecision(0.01d))
                .isCloseTo(5.25d, Percentage.withPercentage(1.0d))
                .isGreaterThan(5.25d)
                .isLessThan(5.26d);
    }
}