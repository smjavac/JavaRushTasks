package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
    private String fullname = null;
    private String readLine = "";
        public void setFileName(String fullFileName) {
            fullname = fullFileName;
        }

        public String getFileContent() {
            return readLine;
        }

        @Override
        public void run() {
            BufferedReader reader = null;

            try {
                reader = new BufferedReader(new FileReader(fullname));
                while (reader.ready()) {

                     readLine += reader.readLine() + " ";
                }
              reader.close();
            } catch (FileNotFoundException e) {
                System.out.println("не нашел файл");
            } catch (IOException e) {
                System.out.println("а тут IOException");
            }

        }
    }
}
