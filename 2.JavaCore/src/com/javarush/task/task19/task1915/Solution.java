package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileOutputStream fW = new FileOutputStream(br.readLine()))
        {
            PrintStream consolreader = System.out;
            ByteArrayOutputStream byteA0S = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteA0S);
            System.setOut(printStream);
            testString.printSomething();
            System.setOut(consolreader);
            byte[] bytes = byteA0S.toByteArray();
            String s = byteA0S.toString();
            fW.write(bytes);
            System.out.println(s);
        }



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

