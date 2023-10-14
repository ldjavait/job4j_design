package ru.job4j.assertj.collections;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "third", "four", "five");
        assertThat(array)
                .hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkToList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("1", "2", "3", "4", "5");
        assertThat(list)
                .isNotEmpty()
                .hasSize(5)
                .contains("3")
                .containsSequence("4", "5")
                .startsWith("1")
                .endsWith("5");
        assertThat(list)
                .element(3)
                .isNotNull();
        assertThat(list)
                .last()
                .isNotNull()
                .isEqualTo("5");
    }

    @Test
    void checkToSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "third", "four", "five", "6");
        assertThat(set)
                .hasSize(6)
                .contains("6")
                .containsAnyOf("third")
                .noneMatch(e -> e.equals("Five"))
                .last()
                .isNotNull();
    }

    @Test
    void checkToMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("1", "2");
        assertThat(map)
                .hasSize(2)
                .containsKey("1")
                .containsValue(1)
                .doesNotContainKey("13")
                .containsEntry("1", 0);
    }
}