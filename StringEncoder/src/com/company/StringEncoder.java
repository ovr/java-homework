package com.company;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Arrays;

public class StringEncoder {
    protected int charMap[];

    protected int offset;

    /**
     * Use your own char map
     * @param charMap char map for decode
     * @param offset table offset
     */
    StringEncoder(int[] charMap, int offset) {
        this.offset = offset;
        this.charMap = charMap;
    }

    /**
     * Generate char map with custom $size
     * @param size size of charmap table
     * @param offset table offset
     */
    StringEncoder(int size, int offset) {
        this.charMap = new int[size];

        this.offset = offset;

        for (int i = 0; i < size; i++) {
            this.charMap[i] = i + 10000;
        }
    }

    /**
     * Decode your string
     *
     * @param encodedStr input encoded int[]
     * @return int[]
     */
    public String decode(int[] encodedStr) {
        StringBuilder str = new StringBuilder();
        Boolean found = false;

        for (int c : encodedStr) {
            found = false;

            for (int position = 0; position < this.charMap.length; position++) {
                if (c == this.charMap[position]) {
                    found = true;
                    str.append((char) (position+this.offset));
                    break;
                }
            }

            if (!found) {
                str.append((char) c);
            }
        }

        return str.toString();
    }

    /**
     * Encode your string
     *
     * @param str input string for encode
     * @return int[]
     */
    public int[] encode(String str) {
        int[] result = new int[str.length()];

        int position = 0;

        for (char c : str.toCharArray()) {
            if ((int) c > this.offset && (int) c < (this.offset + this.charMap.length)) {
                result[position] = this.charMap[(int) c - this.offset];
            } else {
                result[position] = (int) c;
            }

            position++;
        }

        return result;
    }
}
