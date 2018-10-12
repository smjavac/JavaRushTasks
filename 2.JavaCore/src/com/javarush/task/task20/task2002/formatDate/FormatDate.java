package com.javarush.task.task20.task2002.formatDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatDate {
    public static void main(String[] args) {
        String strDate= "Thu Jul 07 00:00:00 MSD 1983";
        SimpleDateFormat myDateFormat = new SimpleDateFormat( "EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH); //Задали шаблон входящей строки

        try {
            Date date = myDateFormat.parse(strDate); //получили дату
            myDateFormat.applyPattern("dd MM yyyy"); //изменили шаблон
            strDate = myDateFormat.format(date);     //получили дату в нужном формате
            System.out.println(strDate);			 //вывели результат на печать
        } catch (ParseException e) {
            System.out.println("Invalid Date Parser Exception");
        }
    }
}
