package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader bReader = new BufferedReader(new FileReader(br.readLine()))) {
                 while (bReader.ready()) {
                     int count = 0;
                     String s1 = bReader.readLine();
                     String[] s = s1.split(" ");

                        for (int j = 0; j < Solution.words.size(); j++)
                            for (int i = 0; i < s.length; i++)
                                if (Solution.words.get(j).equals(s[i])) count++;

                     if (count == 2) System.out.println(s1);
                 }
        }
    }
}

