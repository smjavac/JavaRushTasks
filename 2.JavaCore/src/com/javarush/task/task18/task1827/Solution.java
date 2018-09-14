package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0)return;
      String fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();
        List<String> listLine = new ArrayList<>();
        List<Integer> listId = new ArrayList<>();

      try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
          while (reader.ready()) {
              listId.add(Integer.parseInt(reader.readLine().substring(0,8).trim()));
          }
      }
        Collections.sort(listId);
      int max = listId.get(listId.size()-1);
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
          if (args[0].equals("-c")){
            writer.newLine();
            writer.write(String.format("%8s%-30s%-8s%-4s", ++max, args[1], args[2], args[3]));
          }
      }



    }
}
