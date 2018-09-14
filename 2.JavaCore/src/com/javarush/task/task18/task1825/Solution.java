package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//  FileInputStream fis = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        //  FileInputStream fis2 = new FileInputStream(br.readLine());
        BufferedReader reader;// = new BufferedReader(new InputStreamReader(new FileInputStream(br.readLine())));
        Set<String> set = new TreeSet<>();
        String s = null;
        Set<String> set2 = new HashSet<>();
        //   Map<String,String> map = new TreeMap<>();
        //  CharBuffer charBuffer;
        while (!(s = br.readLine()).equals("end")) {
            //  s = br.readLine();
            //   if (s.equals("end")) break;
            //      reader = new BufferedReader(new InputStreamReader(new FileInputStream(s)));
            //   while (reader.ready())
            // reader = new BufferedReader(new InputStreamReader(new FileInputStream(s)));

            set.add(s);
            //       map.put(s, reader.readLine());
        }
        for (String i : set) {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(i)));
            while (reader.ready())
                // reader = new BufferedReader(new InputStreamReader(new FileInputStream(s)));
            set2.add(reader.readLine());


                     //        for (Map.Entry<String,String> entry : map.entrySet()){
                     //            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        for (String s2 : set2)
            System.out.println(s2);
    }
}


