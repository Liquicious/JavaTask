package org.example;

public class TestClass {
    // boolean, byte, short, int , long, double, float, char, string
    private boolean bo;
    private byte by;
    private short sh;
    private int in;
    private long lo;
    private double dou;
    private float fl;
    private char ch;
    private String st;
    TestClass()
    {
        bo = true;
        by = (byte) 12;
        sh = 13;
        in = 14;
        lo = 15;
        dou = 1.6;
        fl = (float) 1.7;
        ch = 'a';
        st = "string";
    }
    public void showFields()
    {
        System.out.println(bo);
        System.out.println(by);
        System.out.println(sh);
        System.out.println(in);
        System.out.println(lo);
        System.out.println(dou);
        System.out.println(fl);
        System.out.println(ch);
        System.out.println(st);
    }
}
