package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws Exception
    {
        // напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        InputStream input = new FileInputStream(bf.readLine());
        while (input.available() > 0)
        {System.out.print((char)input.read());}
        input.close();
        bf.close();
    }
}