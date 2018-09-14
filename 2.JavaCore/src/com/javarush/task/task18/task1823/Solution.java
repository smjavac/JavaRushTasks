package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ReadThread readThread;
        while (true) {
            String s = br.readLine();
            if (s.equals("exit")) break;
            readThread = new ReadThread(s);
            readThread.start();
        }
        br.close();
    }

    public static class ReadThread extends Thread {
        String name;
        FileInputStream fis;

        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            name = fileName;
            fis = new FileInputStream(name);
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            byte[] bytes = new byte[256];
            try {
                while (fis.available() > 0) {
                    int i = fis.read();
                    bytes[i]++;
                }
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            int max = 0;
            for (int i = 1; i < bytes.length; i++) {
                int j = 0;
                if (bytes[i] > bytes[j]) {
                    bytes[j] = bytes[i];
                    max = i;
                }
            }
            resultMap.put(name, max);
        }
    }
}
