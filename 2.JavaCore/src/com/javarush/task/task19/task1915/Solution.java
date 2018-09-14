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
            PrintStream printFile = new PrintStream(fW);
            System.setOut(printStream);
            testString.printSomething();
            System.setOut(consolreader);
            String s = byteA0S.toString();
            // byte[] bytes = byteA0S.toByteArray();  // можно и так записать в файл
            //   fW.write(bytes);
            printFile.println(s);
            System.out.println(s);
        }



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

