package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(br.readLine()));
             BufferedReader bufferedReader2 = new BufferedReader(new FileReader(br.readLine()))){
            String line1;
            String line2;
            while (bufferedReader1.ready()||bufferedReader2.ready()){
                line1 = bufferedReader1.readLine();
                line2 = bufferedReader2.readLine();
                if (line1.equals(line2))lines.add(new LineItem(Type.SAME,line1));
               else if (line1.isEmpty()/*line1.length()==0 && line2.length() > 0*/) lines.add(new LineItem(Type.ADDED,line2));
               else  lines.add(new LineItem(Type.REMOVED,line1));
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
