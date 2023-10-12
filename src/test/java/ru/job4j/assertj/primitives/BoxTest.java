package ru.job4j.assertj.primitives;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    public void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    public void isThisTetrahedron() {
        Box box = new Box(4, 4);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
    }

    @Test
    public void isThisCube() {
        Box box = new Box(8, 3);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube");
    }

    @Test
    public void checkGetNumberOfVerticesCube() {
        Box box = new Box(8, 3);
        int rsl = box.getNumberOfVertices();
        assertThat(rsl).isEven()
                .isPositive()
                .isLessThan(9)
                .isEqualTo(8);
    }

    @Test
    public void checkGetNumberOfVerticesSphere() {
        Box box = new Box(0, 10);
        int rsl = box.getNumberOfVertices();
        assertThat(rsl).isEqualTo(0)
                .isGreaterThan(-1)
                .isNotEqualTo(1);
    }

    @Test
    public void isExistTetrahedron() {
        Box box = new Box(4, 4);
        boolean rsl = box.isExist();
        assertThat(rsl).isTrue();
    }

    @Test
    public void isNotExist() {
        Box box = new Box(13, 133);
        boolean rsl = box.isExist();
        assertThat(rsl).isFalse();
    }

    @Test
    public void getAreaCube() {
        Box box = new Box(8, 3);
        double rsl = box.getArea();
        assertThat(rsl).isLessThan(55)
                .isGreaterThan(10)
                .isEqualTo(54)
                .isPositive();
    }

    @Test
    public void getAreaUnknown() {
        Box box = new Box(128, 33);
        double rsl = box.getArea();
        assertThat(rsl).isEqualTo(0);
    }
}