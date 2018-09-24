package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader buffReader1 = new BufferedReader(new FileReader(br.readLine()));
        BufferedReader buffReader2 = new BufferedReader(new FileReader(br.readLine()))) {
            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            while (buffReader1.ready()){
                list1.add(buffReader1.readLine());
            }

            while (buffReader2.ready()){
                list2.add(buffReader2.readLine());
            }
            int j = 0;
            for (int i = 0; i < list1.size()|| j< list2.size();) {
                try {

                if (list1.get(i).equals(list2.get(j))) {
                    lines.add(new LineItem(Type.SAME, list1.get(i)));
                    i++;
                    j++;
                } else if (list1.get(i).equals(list2.get(j + 1))) {
                    lines.add(new LineItem(Type.ADDED, list2.get(j)));
                    j++;
                } else if ((!list1.get(i).equals(list2.get(j + 1)))) {
                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                    i++;
                }
              }
              catch (IndexOutOfBoundsException e)  {
                  if (list2.size() < list1.size()) {
                      lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                  }else lines.add(new LineItem(Type.ADDED, list2.get(j)));
//
                    break;
//
                }
            }

            for (LineItem lineItem: lines){
                System.out.println(lineItem.type + " " + lineItem.line);
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
