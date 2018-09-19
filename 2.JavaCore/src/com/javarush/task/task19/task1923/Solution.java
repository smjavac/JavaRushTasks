package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader buffR = new BufferedReader(new FileReader(args[0]));
             BufferedWriter buffW = new BufferedWriter(new FileWriter(args[1]))) {
            String line;
            while ((line = buffR.readLine()) != null){
              String[] s = line.split(" ");
              for (String s2 : s){
                  Pattern pattern = Pattern.compile(".*\\d+.*");
                  Matcher m = pattern.matcher(s2);
                  if (m.find()) buffW.write(s2 + " ");
              }
            }
        }
    }
}
