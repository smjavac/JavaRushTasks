package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        while (true){
//            String s = reader.readLine();
//          //  Integer a = Integer.parseInt(s);
//          //  Double d = Double.parseDouble(s);
//            if (s.equals("exit")) break;
//            try {
//                 if (s.contains(".")) Solution.print(Double.parseDouble(s));
//
//                 else if (Integer.parseInt(s) > 0 && Integer.parseInt(s) < 128) Solution.print(Short.parseShort(s));
//                 else if (Integer.parseInt(s) <= 0 || Integer.parseInt(s) >= 128) Solution.print(Integer.parseInt(s));
//            } catch (Exception e){
//                Solution.print(s);
//            }
//
//
//        }
            String key = reader.readLine();
        while (!key.equals("exit")){
            try {
                if (key.contains("."))
                    print((Double) Double.valueOf(key));
                else if (Short.valueOf(key) > 0 && Short.valueOf(key) < 128)
                    print((short) Short.valueOf(key));
                else if (Integer.valueOf(key) <= 0 || Integer.valueOf(key) >= 128)
                    print((Integer) Integer.valueOf(key));
//                else print((String) key);
            }
            catch (NumberFormatException e) {
                print((String) key);
            }
            key = reader.readLine();
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
