package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//public class Solution {
//    public static void main(String[] args) throws IOException {
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(br.readLine()))){
//            StringBuilder stringBuilder = new StringBuilder();
//            String text;
//
//
//
//            while (bufferedReader.ready()) {
//                stringBuilder.append(bufferedReader.readLine());
//            }
//            text = stringBuilder.toString();
//            String tag = args[0];
//            String[] array;
//            List<Integer> list1 = new ArrayList<>();
//            List<Integer> list2 = new ArrayList<>();

//            Document document = Jsoup.parse(text,  "", Parser.xmlParser());
//            Elements elements = document.select(tag);
//            for (Element s: elements) System.out.println(s);


//        }
//    }
//}
public class Solution {
    public static void main(String[] args)throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String path  = consoleReader.readLine();
        consoleReader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(path));
        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready()){
            stringBuilder.append(fileReader.readLine());
        }
        fileReader.close();
        String data = stringBuilder.toString();

        String startTag = "<" + args[0];
        String endTag = "</" + args[0] + ">";
        int startTagIndex;
        int endTagIndex;
        int tempStartTagIndex = 0;
        while(tempStartTagIndex != -1){
            startTagIndex = data.indexOf(startTag, tempStartTagIndex);
            System.out.println("startTagIndex: " + startTagIndex);
            if(startTagIndex == -1 ){
                return;
            }
            endTagIndex = data.indexOf(endTag, startTagIndex);
            System.out.println("endTagIndex: " + endTagIndex);
            tempStartTagIndex = data.indexOf(startTag, startTagIndex + 1);
            System.out.println("tempStartTagIndex :" + tempStartTagIndex);

            if(tempStartTagIndex < endTagIndex && tempStartTagIndex != -1){
                endTagIndex = data.indexOf(endTag, endTagIndex + 1);
                System.out.println("endTagIndex: " + endTagIndex);
            }

            System.out.println(data.substring(startTagIndex, endTagIndex + endTag.length()));


        }


    }
}

