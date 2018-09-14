package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(br.readLine());
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
//        List<String> list = new ArrayList<String>();
//
//        while ( bufferedReader.ready())list.add(bufferedReader.readLine());
//
//        for(String s: list) if (s.subSequence(0,s.indexOf(" ")).equals(args[0]))  System.out.println(s);
//
//        fis.close();
//        bufferedReader.close();
//        br.close();


        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       //    это более короткое решение
        BufferedReader bufferedReader = new BufferedReader(new FileReader(br.readLine()));
        String line;
        while ( bufferedReader.ready()){
            line = bufferedReader.readLine();
            if (line.subSequence(0, line.indexOf(" ")).equals(args[0])) System.out.println(line); //  if (line.startsWith(args[0] + " "))
        }                                                                                         //  а можно еще такое условие
        bufferedReader.close();
        br.close();
         */

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        File file = new File(reader.readLine());
//
//
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(file));
//            String line;
//            while ((line = br.readLine()) != null) {
//
//                if (line.startsWith(args[0] + " ")){
//                    System.out.println(line);
//                }
//            }
//            br.close();
//        }
//        catch (IOException e) {
//            // Обрабатываем ошибки
//        }
//

//        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in)); //решение со SPLIT
//        String filemame = reader.readLine();
//        int id = Integer.parseInt(args[0]);
//        BufferedReader fread = new BufferedReader(new FileReader(filemame));
//        String s =null;
//        while ((s= fread.readLine())!=null){
//            String[] str = s.split(" ");
//            if(str[0].equals(String.valueOf(id))){
//                System.out.println(s);
//            }
//        }
//        fread.close();



        String id = args[0];
       // Два часа усилий:ц ответ идеальный - валидатор ни один вариант не принимает! В итоге: BufferedReader + FileReader + лямбда:
        BufferedReader bufferedReaderfile = new BufferedReader(new InputStreamReader(fis));
        bufferedReaderfile.lines().filter(s -> s.startsWith(id + " ")).forEach(System.out ::println);

       //Скушал! Три строчки кода всего! И никаких циклов и преобразований! Не зря все так ждали восьмёрку!

    }
}


