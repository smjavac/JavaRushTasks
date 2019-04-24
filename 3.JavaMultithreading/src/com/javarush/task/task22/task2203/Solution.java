package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException  {
        StringBuilder strBuilder = new StringBuilder();
        if (string == null || string.split("\t").length < 3) {
            throw new TooShortStringException();
        } else {
                strBuilder.append(string.split("\t")[1]);
        }
        return strBuilder.toString(); 
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {

        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
