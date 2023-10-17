package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CyclicIterator<T> implements Iterator<T> {
    private List<T> data;
    private int index;

    public CyclicIterator(List<T> data) {
        this.data = new ArrayList<>(data);
    }

    @Override
    public boolean hasNext() {
        if (index >= data.size()) {
            index = 0;
        }
        return !data.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data.get(index++);
    }
}
