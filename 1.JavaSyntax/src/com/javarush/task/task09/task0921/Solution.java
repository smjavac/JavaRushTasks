package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        try {

           Boolean a = true;
           while (a) {
               arrayList.add(scanner.nextInt());
           }
       }
       catch (InputMismatchException e){
           for (int i = 0; i < arrayList.size(); i++)
               System.out.println(arrayList.get(i));
           {

           }
       }
    }
}
