package com.company;

public class IntArray {

    private int[] elements = null;

    private int lastKey = 0;

    private int count;

    public int getCount()
    {
        return this.count;
    }

    public IntArray(final int count)
    {
        this.elements = new int[count];

        for ( int i = 0; i < count; i++) {
            this.elements[i] = 0;
        }

        this.count = count;
    }

    public void resize(final int size)
    {
        int[] elements = new int[size];

        System.arraycopy(this.elements, 0, elements, 0, this.count);

        for (int i = count; i < size; i++) {
            elements[i] = 0;
        }

        this.elements = elements;
        this.count = size;
    }

    public void add(int value)
    {
        if (this.lastKey+1 > this.count-1) {
            this.resize(this.count*2);
        }

        this.lastKey++;
        this.elements[this.lastKey] = value;
    }

    public int summ()
    {
        int result = 0;

        for (int element: this.elements) {
            result += element;
        }

        return result;
    }
}
