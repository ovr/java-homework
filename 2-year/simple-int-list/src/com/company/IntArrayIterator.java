package com.company;

import java.util.Iterator;

/**
 * Created by ovr on 07.11.14.
 */
public class IntArrayIterator implements Iterator<Integer>
{
    protected IntArray list;

    protected int position = 0;

    IntArrayIterator(IntArray list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
       return this.position + 1 < this.list.getCount();
    }

    @Override
    public Integer next() {
        if (this.hasNext()) {
            Integer result = this.list.get(this.position);
            this.position++;
            return result;
        }

        return null;
    }
}
