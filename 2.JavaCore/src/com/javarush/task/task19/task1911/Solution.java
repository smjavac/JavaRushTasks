package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream byteAOS = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteAOS);
        System.setOut(printStream);
        testString.printSomething();
        String s = byteAOS.toString();
        System.setOut(consoleStream);
        System.out.println(s.toUpperCase());

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}