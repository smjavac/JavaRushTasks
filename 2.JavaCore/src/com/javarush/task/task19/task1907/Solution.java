package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String filereader = br.readLine();
            FileReader fR = new FileReader(filereader);
            StringBuilder sBuilder = new StringBuilder();
            while (fR.ready()){
                sBuilder.append((char) fR.read());
            }
            fR.close();
            String file = sBuilder.toString();
            int a = 0;
            String[] worlds = file.split("\\W");
            for (String s: worlds){
                if (s.equals("world")) a++;
            }

            System.out.println(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
