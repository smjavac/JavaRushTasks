package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        ArrayList arr = new ArrayList();
        Set set = new TreeSet();
        while (fis.available() > 0){
            arr.add(fis.read());

        }
        fis.close();
        set.addAll(arr);
        for (Object b : set){
            System.out.print(b + " ");
        }


//        FileInputStream inputStream=new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
//long[] arr=new long[256];
//while(inputStream.available()>0)
//    arr[inputStream.read()]++;
//inputStream.close();
//for(int i=0;i<256;i++)
//    if(arr[i]>0)
//        System.out.print(i+" ");
    }
}
