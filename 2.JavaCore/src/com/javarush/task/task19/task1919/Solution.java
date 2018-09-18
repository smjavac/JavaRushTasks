package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

       BufferedReader bReader = new BufferedReader(new FileReader(args[0]));
           Map<String, Double> map = new TreeMap<>();
          // String s = null;
           String name;
           Double d;
           while (bReader.ready()) {
              String[] s = bReader.readLine().split(" ");
               name = s[0];
               d = Double.parseDouble(s[1]);
               if (map.containsKey(name)) {
                   map.put(name, map.get(name) + d);

               }else map.put(name, d);
           }
           for (Map.Entry<String, Double> maps : map.entrySet()){
               System.out.println(maps.getKey() + " " + maps.getValue());
           }
           bReader.close();
    }
}
