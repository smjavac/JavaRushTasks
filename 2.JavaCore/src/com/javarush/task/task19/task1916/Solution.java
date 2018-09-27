package com.javarush.task.task19.task1916;

<<<<<<< HEAD
import java.io.*;
=======
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
>>>>>>> 48f151b95ff9141f410942b4492892d16276fee5
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

<<<<<<< HEAD
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
=======
public class Solution{
    public static List<LineItem> lines=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String file1=reader.readLine();
        String file2=reader.readLine();
        reader.close();
        BufferedReader reader1=new BufferedReader(new FileReader(file1));
        BufferedReader reader2=new BufferedReader(new FileReader(file2));
        while(true){
            if(reader1.ready()){
                if(reader2.ready()){
                    reader1.mark(500);
                    reader2.mark(500);
                    file1=reader1.readLine();
                    file2=reader2.readLine();
                    if(file2.equals(file1)) lines.add(new LineItem(Type.SAME,file1));
                    else{
                        if(file1.equals(reader2.readLine())){
                            reader1.reset();
                            reader2.reset();
                            lines.add(new LineItem(Type.ADDED,reader2.readLine()));
                        }else{
                            lines.add(new LineItem(Type.REMOVED,file1));
                            reader2.reset();
                        }
                    }
                }else lines.add(new LineItem(Type.REMOVED,reader1.readLine()));
            }else{
                if(reader2.ready()) lines.add(new LineItem(Type.ADDED,reader2.readLine()));
                else break;
            }
        }
        reader1.close();
        reader2.close();
        for(LineItem l : lines)System.out.println(l.type+" "+l.line);
>>>>>>> 48f151b95ff9141f410942b4492892d16276fee5
    }
    public static enum Type{
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }
    public static class LineItem{
        public Type type;
        public String line;
        public LineItem(Type type,String line){
            this.type=type;
            this.line=line;
        }
    }
}

//public class Solution {
//    public static List<LineItem> lines = new ArrayList<LineItem>();
//
//    public static void main(String[] args) throws IOException {
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader buffReader1 = new BufferedReader(new FileReader(br.readLine()));
//        BufferedReader buffReader2 = new BufferedReader(new FileReader(br.readLine()))) {
//            List<String> list1 = new ArrayList<>();
//            List<String> list2 = new ArrayList<>();
//            while (buffReader1.ready()){
//                list1.add(buffReader1.readLine());
//            }
//
//            while (buffReader2.ready()){
//                list2.add(buffReader2.readLine());
//            }
//            int j = 0;




//            for (int i = 0; i < list1.size()|| j< list2.size();) {
//                try {
//
//                if (list1.get(i).equals(list2.get(j))) {
//                    lines.add(new LineItem(Type.SAME, list1.get(i)));
//                    i++;
//                    j++;
//                } else if (list1.get(i).equals(list2.get(j + 1))) {
//                    lines.add(new LineItem(Type.ADDED, list2.get(j)));                // 1-й вариант
//                    j++;
//                } else if ((!list1.get(i).equals(list2.get(j + 1)))) {
//                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
//                    i++;
//                }
//              }
//              catch (IndexOutOfBoundsException e)  {
//                  if (list2.size() < list1.size()) {
//                      lines.add(new LineItem(Type.REMOVED, list1.get(i)));
//                  }else lines.add(new LineItem(Type.ADDED, list2.get(j)));
////
//                    break;
////
//                }
//            }


//            for (int i = 0; i < list1.size(); i++) {
//                try {
//                    if (list1.get(i).equals(list2.get(0))) {
//                        lines.add(new LineItem(Type.SAME, list1.get(i)));
//                        list2.remove(0);
//                    } else if (list1.get(i).equals(list2.get(1))) {
//                        lines.add(new LineItem(Type.ADDED, list2.get(0)));
//                        list2.remove(0);
//                        i--;
//                    } else {
//                        lines.add(new LineItem(Type.REMOVED, list1.get(i)));          // 2-й вариант
//                    }
//                } catch (IndexOutOfBoundsException e) {
//                    if (list1.size() > list2.size()) {
//                        lines.add(new LineItem(Type.REMOVED, list1.get(i)));
//                    } else {
//                        lines.add(new LineItem(Type.ADDED, list2.get(0)));
//                    }
//                }
//            }



//            for (LineItem lineItem: lines){
//                System.out.println(lineItem.type + " " + lineItem.line);
//            }
//        }
//    }
//
//
 //   public static enum Type {
//        ADDED,        //добавлена новая строка
//        REMOVED,      //удалена строка
//        SAME          //без изменений
//    }
//
//    public static class LineItem {
//        public Type type;
//        public String line;
//
//        public LineItem(Type type, String line) {
//            this.type = type;
//            this.line = line;
//        }
//    }
//}
