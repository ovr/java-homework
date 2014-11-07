package com.company;

/**
 * Created by ovr on 07.11.14.
 */
public class MyPlusFunction implements MyInterface {
    protected int result;

    public void method(int element) {
        System.out.println("Work " + element);
        this.result += element;
    }

    public int getResult()
    {
        return this.result;
    }
}
