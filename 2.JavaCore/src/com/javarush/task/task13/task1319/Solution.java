package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String s = br.readLine();
           // InputStream input = new FileInputStream(br.readLine());
            OutputStream out = new FileOutputStream(s);
            out.write(s.getBytes());
            if (s.equals("exit")) break;
        }

        br.close();
    }
}
