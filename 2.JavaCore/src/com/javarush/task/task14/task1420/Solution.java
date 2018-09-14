package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public Solution()  {
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            int c = 0;
        if (a <= 0 || b <= 0) { throw new Exception();
        }
            for (int i = Math.min(a,b); i > 0; i--) {
                if((a % i == 0) && (b % i == 0)){
                    c = i;
                    break;
                }
            }

            System.out.println(c);


       //if (a < b && b % a == 0) c = a;
      // else if (b < a && a % b == 0) c = b;


    }


   }






