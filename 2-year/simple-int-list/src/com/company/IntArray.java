package com.company;

import java.util.Iterator;

public class IntArray implements Iterable {

    private int[] elements = null;

    private int lastKey = 0;

    public int getCount() {
        return this.elements.length;
    }

    public IntArray(int count) {
        this.elements = new int[count];

        for (int i = 0; i < count; i++) {
            this.elements[i] = 0;
        }
    }

    public void resize(final int size) {
        int[] elements = new int[size];

        System.arraycopy(this.elements, 0, elements, 0, this.elements.length);

        for (int i = this.elements.length; i < size; i++) {
            elements[i] = 0;
        }

        this.elements = elements;
    }

    public void add(int value) {
        if (this.lastKey + 1 > this.elements.length) {
            this.resize(this.elements.length * 2);
        }

        this.elements[this.lastKey] = value;
        this.lastKey++;
    }

    public int summ()
    {
        int result = 0;

        for (int element: this.elements) {
            result += element;
        }

        return result;
    }

    public void iterate(MyInterface inter)
    {
        for (int element: this.elements) {
            inter.method(element);
        }
    }

    public int get(int index)
    {
        return this.elements[index];
    }

    @Override
    public IntArrayIterator iterator() {
        return new IntArrayIterator(this);
    }
}
