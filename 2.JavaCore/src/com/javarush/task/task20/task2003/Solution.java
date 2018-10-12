package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(br.readLine());
         load(fis);
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
             //  PrintWriter pW = new PrintWriter(outputStream);
               Properties prop = new Properties();
               if(!properties.isEmpty())
               for (Map.Entry<String,String> entry : properties.entrySet()) prop.setProperty(entry.getKey(),entry.getValue());

               prop.store(outputStream, "");
               outputStream.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream));
        Properties prop2 = new Properties();
        prop2.load(inputStream);
        for (String s : prop2.stringPropertyNames()) properties.put(s, prop2.getProperty(s));
        inputStream.close();
    }

    public static void main(String[] args) throws Exception {
    }
}
