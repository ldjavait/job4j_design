package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Класс, который равномерно распределяет данные из итератора по переданным ему спискам.
 */
public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        int i = 0;
        while (source.hasNext()) {
            nodes.get(i++).add(source.next());
            if (i == nodes.size()) {
                i = 0;
            }
        }
    }
}
