package org.example;

public class Main {
    public static void main(String[] args) {
        Generator gen = new Generator();
        TestClass test = new TestClass();

        test.show();
        System.out.println("-----------------");

        gen.generate(test);
        test.show();
    }
}