package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader bReader = new BufferedReader(new FileReader(br.readLine()));
             BufferedWriter bWriter = new BufferedWriter(new FileWriter(br.readLine()))){
             String s = bReader.readLine().replaceAll("[\\p{Punct}\\n]", "");

            bWriter.write(s);
        }
    }
}
