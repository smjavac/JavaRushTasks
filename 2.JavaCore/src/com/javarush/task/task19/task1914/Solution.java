package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consolreader = System.out;
        ByteArrayOutputStream byteAOS = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteAOS);
        System.setOut(printStream);
        testString.printSomething();
        String s = byteAOS.toString().trim();
        System.setOut(consolreader);
        String [] num = s.split(" ");
        int a = Integer.parseInt(num[0]), b = Integer.parseInt(num[2]), result = 0;

        switch (num[1]){
            case "+": result = a + b; break;
            case "-": result = a - b; break;
            case "*": result = a * b; break;
        }
        System.out.println(s + " " + result);
//        Integer a = Integer.valueOf(s.substring(0, s.indexOf(" ")));
//        Integer b = Integer.valueOf(s.substring(s.indexOf(" ") + 3 , s.lastIndexOf(" ")));
//        int result = 0;
//        if (s.contains("+"))result = a + b;
//           // System.out.print(s + " " + result);
//
//
//        if (s.contains("-")) result = a - b;
//
//
//        if (s.contains("*")) result = a * b;
//
//        System.out.println(s + " " + result);
//
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

