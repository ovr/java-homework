package com.company;

public class Main {

    public static void main(String[] args) {
	    IntArray elements = new IntArray(10);
        elements.add(1);
        elements.add(2);
        elements.add(3);
        elements.add(4);
        elements.add(5);
        elements.add(6);
        elements.add(7);
        elements.add(8);
        elements.add(9);
        System.out.println(elements.getCount());

        elements.add(10);
        System.out.println(elements.getCount());

        //realloc x2 10*2=20
        elements.add(11);
        System.out.println(elements.getCount());


        elements.add(12);
        elements.add(13);
        elements.add(14);
        elements.add(15);
        elements.add(16);
        System.out.println(elements.getCount());

        System.out.println("Summ " + elements.summ());
    }
}
