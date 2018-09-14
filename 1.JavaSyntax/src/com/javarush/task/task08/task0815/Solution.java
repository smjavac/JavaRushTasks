package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
       HashMap<String, String>  map = new HashMap<String, String>();
      map.put("Юсупов", "Саид"); //напишите тут ваш код
      map.put("Урусханов", "Заур"); //напишите тут ваш код
      map.put("Шаипов", "Заур"); //напишите тут ваш код
      map.put("Исупов", "Джабраил"); //напишите тут ваш код
      map.put("Ясупов", "Сулиман"); //напишите тут ваш код
      map.put("Эсупов", "Ибрахим"); //напишите тут ваш код
      map.put("Мадагов", "Алихан"); //напишите тут ваш код
      map.put("Оморов", "Аднан"); //напишите тут ваш код
      map.put("Арусханов", "Джабраил"); //напишите тут ваш код
      map.put("Дамбаев", "Саид");
      return map;//напишите тут ваш код

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int a = 0;

        for (String s: map.values()){
            if (s.equals(name)) a++;
        }
        return a;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int b = 0;
        for (String f: map.keySet()){
            if (f.equals(lastName)) b++;
        }
        return b;
    }

    public static void main(String[] args) {

    }
}
