package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
           BufferedReader bufferedReader = new BufferedReader(new FileReader(br.readLine()));
           BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(br.readLine()));
           String s = bufferedReader.readLine();
           String [] num = s.split(" ");
            bufferedReader.close();
            for (String a : num){
              //  System.out.println(a);
                try {
                    Integer.parseInt(a);
                    bufferedWriter.write(a+" ");
                    bufferedWriter.flush();
                } catch(NumberFormatException e) {

                }
            }
            bufferedWriter.close();
        }
    }
}
