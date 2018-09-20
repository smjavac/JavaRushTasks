package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader buffR = new BufferedReader(new FileReader(args[0]));
             BufferedWriter buffW = new BufferedWriter(new FileWriter(args[1]))) {
            String line;
            StringBuilder strBuild = new StringBuilder();
            while ((line = buffR.readLine()) != null) {
                String[] s = line.split(" ");
//                for (int i = 0; i < s.length; i++) {
//                    if (s[i].length() > 6) {
//                        if (i == s.length - 1){
//                            buffW.write(s[i]+"\n");
//                        }else buffW.write(s[i] + ",");
//
//                    }
//                }

                for (String s1: s){
                    if (s1.length() > 6) strBuild.append(s1+",");
                }
            }
            buffW.write(strBuild.toString().substring(0, strBuild.length()-1) );
        }
    }
}
