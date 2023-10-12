package ru.job4j.iterator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ArrayItTest {
    @Test
    public void whenMultiCallHasNextThenTrue() {
        ArrayIt iterator = new ArrayIt(new int[]{1, 2, 3});
        boolean rsl = iterator.hasNext();
        assertThat(rsl).isTrue();
        assertThat(iterator.hasNext()).isTrue();
    }

    @Test
    public void whenReadSequence() {
        ArrayIt iterator = new ArrayIt(new int[]{1, 2, 3});
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.next()).isEqualTo(3);
    }
}