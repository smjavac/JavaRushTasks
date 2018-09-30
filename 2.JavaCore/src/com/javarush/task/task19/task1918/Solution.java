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
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(br.readLine()))){
            StringBuilder stringBuilder = new StringBuilder();
            String text;



            while (bufferedReader.ready()) {
                stringBuilder.append(bufferedReader.readLine());
            }
            text = stringBuilder.toString();
            String tag = args[0];
            Document document = Jsoup.parse(text,  "", Parser.xmlParser());
            Elements elements = document.select(tag);
            for (Element s: elements) System.out.println(s);


        }
    }
}
