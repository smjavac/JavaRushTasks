package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
        String [] abc = new String[5];
    }

    public static ArrayList<String>[] createList() {
       ArrayList<String> list1 = new ArrayList<String>();
       list1.add("said");
       ArrayList<String> list2 = new ArrayList<String>();
       list2.add("zaur");
        ArrayList<String>[] arrayOfStringList = new ArrayList[2];//напишите тут ваш код
        arrayOfStringList[0] = list1;
        arrayOfStringList[1] = list2;
        return arrayOfStringList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}