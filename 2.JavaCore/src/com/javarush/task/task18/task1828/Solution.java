package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0)return;
        List<String> listLine = new ArrayList<>();
    //    List<Integer> listId = new ArrayList<>();

        String fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();
//        Set<String> setLine = new HashSet<>();
//        Set<Integer> setId = new HashSet<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
       //    int count = 0;
            while (reader.ready()) {
                listLine.add(reader.readLine());
               // listLine.add(reader.readLine().substring(0,8).trim());
              //  listId.add(Integer.parseInt(listLine.get(count).substring(0,8).trim()));
              //  count++;
            }
            if ("-u".equals(args[0])){

                for(int i = 0; i < listLine.size(); i++){
                    String s = listLine.get(i).substring(0,8).trim();
                    if (s.equals((args[1]))){
                        listLine.set(i, String.format("%8s%-30s%-8s%-4s", args[1], args[2], args[3], args[4]));
                    }
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
                       writer.newLine();
                       writer.write(listLine.get(i));
                    }
                }
            }

             else if ("-d".equals(args[0])){
                for(int i = 0; i < listLine.size(); i++){
                    String s = listLine.get(i).substring(0,8).trim();
                    if (s.equals((args[1]))){
                        listLine.remove(i);
                    }
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
                        writer.newLine();
                        writer.write(listLine.get(i));
                    }
                }
            }
        }
    }
}
