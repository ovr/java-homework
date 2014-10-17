package com.company;

public class Main {

    public static void main(String[] args) {
	    String str = "Привет Мир!$$$$";

        StringEncoder encoder = new StringEncoder(100, 1000);
        int[] result = encoder.encode(str);

        System.out.println(str);

        for(int number: result) {
            System.out.print(number + " ");
        }

        System.out.println();

        System.out.println(encoder.decode(result));
    }
}
