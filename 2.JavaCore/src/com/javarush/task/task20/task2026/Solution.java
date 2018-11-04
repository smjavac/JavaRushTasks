package com.javarush.task.task20.task2026;

import java.util.Arrays;

/*
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };



        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");

    }


   public static int getRectangleCount(byte[][] a) {                           // 1, 1, 0, 0
        int length = a.length;                                                 // 1, 1, 0, 0
        byte[][] b = new byte[a.length+1][a[0].length+1];                      // 1, 1, 0, 0
        for (int i = 0; i < a.length; i++){                                    // 1, 1, 0, 0
            for (int j = 0; j < a[i].length; j++){
                b[i][j] = a[i][j];
            }
        }
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a[i].length; j++) {                            //{1, 1, 0, 0, 1, 0},
                                                                               //{1, 1, 0, 0, 1, 0},
                if (b[i][j - 1] == 1 && b[i][j] == 0) {                        //{1, 1, 0, 0, 0, 0},
                    count++;                                                   //{1, 1, 0, 1, 1, 0}  должно быть 3 учтенные ячейки нужно затирать,
                    if (b[i+1][j - 1] == 1 && b[i+1][j] == 0) count--;                              // чтобы предотвратить повторнеую инициализацию в первых двух строках
                }
                if (b[i][j - 1] == 0 && b[i][j] == 1 && b[i][j+1] !=1) {  //дописал && b[i][j+1] !=1 и  b[i][j]=0;
                    count++;
                    b[i][j]=0;
                    if (b[i+1][j-1] == 0 && b[i+1][j] == 1 && b[i][j+1] !=1) count--;
                }
            }
        }
        return count;
   }

}
