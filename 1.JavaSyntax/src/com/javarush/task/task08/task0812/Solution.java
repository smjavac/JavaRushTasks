package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++){
            arrayList.add(scanner.nextInt());
        }

        int endMax = 1;
        int max = 1;
        for (int j = 0; j < arrayList.size()-1; j++){
            // max = 1;
             if (arrayList.get(j ) == arrayList.get(j+1)) {
                        max++;
                        if (endMax < max) endMax = max;
                    }
                    else max = 1;
                }
        System.out.println(endMax);
        }


    }
