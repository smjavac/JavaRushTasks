package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
       try ( BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
           String filereader = br.readLine();
           String filewriter = br.readLine();
           FileReader fR = new FileReader(filereader);
           FileWriter fW = new FileWriter(filewriter);
           int i = 0;
           while (fR.ready()){
               i++;
               int a = fR.read();
               if (i % 2 == 0) fW.write(a);

           }
           fR.close();
           fW.close();
       }



    }

//    private static void Reader (String reader){
//        try (FileReader fileReader = new FileReader(reader)){
//           int
//            while (fileReader.ready()){
//
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
