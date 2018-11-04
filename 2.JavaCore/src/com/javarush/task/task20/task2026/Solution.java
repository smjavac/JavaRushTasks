package com.javarush.task.task20.task2026;

import java.util.Arrays;

/*
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
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
<<<<<<< HEAD
        for (int i = 0; i < a1.length; i++){
            byte[] a = a1[i];
            for (int j = 0; j < a.length; j++) System.out.print(a[j]);
            System.out.println();
        }
        System.out.println(Arrays.toString(a1));



    }
=======
>>>>>>> f1f67e91986cd77ae69041d8fe27cc7af663e236

//        int length = a1.length;
//        byte[][] b = new byte[a1.length+1][a1[0].length];
//        for (int i = 0; i < a1.length; i++){
//            for (int j = 0; j < a1[i].length; j++){
//                b[i][j] = a1[i][j];
//            }
//        }
//
//        for(int i = 0; i < b.length; i++){
//            for (int j = 0; j < b[i].length; j++){
//                System.out.print(b[i][j]);
//            }
//            System.out.println();
//        }
    }

   public static int getRectangleCount(byte[][] a) {
        int length = a.length;
        byte[][] b = new byte[a.length+1][a[0].length];
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a[i].length; j++){
                b[i][j] = a[i][j];
            }
        }
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a[i].length; j++) {

                if (b[i][j - 1] == 1 && b[i][j] == 0) {
                    count++;
                    if (b[i+1][j - 1] == 1 && b[i+1][j] == 0) count--;
                }
                if (a[i][j - 1] == 0 && a[i][j] != 0) {
                    count++;
                }
            }
        }
        return count;
   }

}
