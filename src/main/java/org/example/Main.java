package org.example;

public class Main {
    public static void main(String[] args) {
        FieldGenerator gen = new FieldGenerator();
        TestClass test = new TestClass();

        test.showFields();

        System.out.println("-----------------");

        gen.generateFields(test);
        test.showFields();
    }
}