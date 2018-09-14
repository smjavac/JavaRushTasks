package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            FileInputStream fis = null;
            String s;
            while (true) {
                s = br.readLine();
                try {
                    fis = new FileInputStream(s);
                    fis.close();
                } catch (FileNotFoundException e){
                    System.out.println(s);

                    break;
                  }
            }
        }
    }

