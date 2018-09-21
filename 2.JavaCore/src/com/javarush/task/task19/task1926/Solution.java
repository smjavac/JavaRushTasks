package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader (new FileReader(br.readLine()))) {
          String line;
         //   byte[] bytes;
            StringBuilder stringBuilder = new StringBuilder();
           while ((line = bufferedReader.readLine())!= null){
             // bytes = line.getBytes();
              stringBuilder.append(line);
               System.out.println(stringBuilder.reverse());
               stringBuilder.setLength(0);
//              for (int i = bytes.length-1; i >=0; i--)
//                  System.out.print((char) bytes[i]);
//               System.out.println();
            }
           }




        }
    }

