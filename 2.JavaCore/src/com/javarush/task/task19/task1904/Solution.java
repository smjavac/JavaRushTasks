package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("D:\\result.txt"));
        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(scanner);
        Person ivan = personScannerAdapter.read();
        Person petr = personScannerAdapter.read();
        System.out.println(ivan.toString());
        System.out.println(petr.toString());
        personScannerAdapter.close();
    }

    public static class PersonScannerAdapter implements PersonScanner{


        private final Scanner fileScanner;
        PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }



        @Override
        public Person read() throws IOException {

            Date date = null;

            String [] lines;
            String s = fileScanner.nextLine();
            lines = s.split(" ");
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
            try {
                date = dateFormat.parse(lines[3]+lines[4]+lines[5]);
            } catch (ParseException e) {
                e.printStackTrace();
            }


            return new Person(lines[1],lines[2],lines[0],date);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }


}
