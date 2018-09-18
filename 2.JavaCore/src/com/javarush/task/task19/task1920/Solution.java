package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bReader = new BufferedReader(new FileReader(args[0]));
           Map<String, Double> map = new TreeMap<>();
           String name = null;
           Double d;
           while (bReader.ready()) {
              String[] s = bReader.readLine().split(" ");
               name = s[0];
               d = Double.parseDouble(s[1]);
               if (map.containsKey(name)) {
                   map.put(name, map.get(name) + d);
               }else map.put(name, d);
           }
           Double max = Double.MIN_VALUE;
           for (Map.Entry<String, Double> maps : map.entrySet()){
               if (maps.getValue() > max) max = maps.getValue();

           }
           for (Map.Entry<String, Double> maps : map.entrySet()){
               if (maps.getValue().equals(max) ) System.out.println(maps.getKey());

           }
           bReader.close();

    }
}

