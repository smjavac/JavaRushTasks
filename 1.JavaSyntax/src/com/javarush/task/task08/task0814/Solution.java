package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
      HashSet<Integer>  set  = new HashSet<Integer>();
      set.add(1);//напишите тут ваш код
      set.add(2);//напишите тут ваш код
      set.add(3);//напишите тут ваш код
      set.add(4);//напишите тут ваш код
      set.add(5);//напишите тут ваш код
      set.add(6);//напишите тут ваш код
      set.add(7);//напишите тут ваш код
      set.add(8);//напишите тут ваш код
      set.add(9);//напишите тут ваш код
      set.add(10);//напишите тут ваш код
      set.add(11);//напишите тут ваш код
      set.add(12);//напишите тут ваш код
      set.add(13);//напишите тут ваш код
      set.add(14);//напишите тут ваш код
      set.add(15);//напишите тут ваш код
      set.add(16);//напишите тут ваш код
      set.add(17);//напишите тут ваш код
      set.add(18);//напишите тут ваш код
      set.add(19);//напишите тут ваш код
      set.add(20);//напишите тут ваш код
        return set;

    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        Iterator <Integer> iterator = set.iterator();

        while (iterator.hasNext()){
          //  int a = (Integer) iterator.next();
            if (iterator.next() > 10) iterator.remove();
             } //напишите тут ваш код

        return set;
    }

    public static void main(String[] args) {


    }
}
