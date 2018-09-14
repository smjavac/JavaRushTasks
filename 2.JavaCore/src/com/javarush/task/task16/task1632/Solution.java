package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true){}
        }
    }
    public static class Thread2 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(01);
            } catch (InterruptedException e) {
                System.out.println( "InterruptedException");
            }
        }
    }
    public static class Thread3 extends Thread {
        @Override
        public void run() {
            while (true){
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        }
    }
    public static class Thread4 extends Thread implements Message {
        @Override
        public void run() {

            while (!interrupted());
        }

        public void showWarning() {

            interrupt();
        }
    }
    public static class Thread5 extends Thread {
        @Override
        public void run() {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int a = 0;
            String s;
            while (true) {
                try {
                    s = br.readLine();

                    if (s.equals("N")){
                        System.out.println(a);
                        break;
                    }

                    a += Integer.parseInt(s);
                } catch (IOException e) {
                    System.out.println("не распарсился");
                } catch (NumberFormatException e) {
                    System.out.println("не распарсился");
                }
            }
        }
    }

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {

    }
}

