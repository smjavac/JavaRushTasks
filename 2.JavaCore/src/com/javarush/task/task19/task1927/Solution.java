package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        try (PrintStream consolStream = System.out;
        ByteArrayOutputStream byteAOS = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteAOS)){
           System.setOut(printStream);
            testString.printSomething();
            System.setOut(consolStream);
            String[] s = byteAOS.toString().split(System.lineSeparator()); //вместо "\n"
            for (int i = 0; i < s.length; i++){
                System.out.println(s[i]);
                if (i%2!=0) System.out.println("JavaRush - курсы Java онлайн");
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
