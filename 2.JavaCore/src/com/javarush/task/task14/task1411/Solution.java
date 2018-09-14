package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        ArrayList<Person> arrayList = new ArrayList<Person>();
        //тут цикл по чтению ключей, пункт 1
        while (true) {
            key = reader.readLine();
            if (key.equals("user")){
                arrayList.add(new Person.User());
               // person = new Person.User();
               // doWork(person);
            }
            else if (key.equals("loser")){
                arrayList.add(new Person.Loser());
               // person = new  Person.Loser();
              //  doWork(person);
            }
            else if (key.equals("coder")){
               arrayList.add(new Person.Coder());
              //  person = new Person.Coder();
               // doWork(person);
            }
            else if (key.equals("proger")){
              arrayList.add(new Person.Proger());
              //  person = new Person.Proger();
              //  doWork(person);
            }
            else break;
        }
            //создаем объект, пункт
            for (Person person1 : arrayList){
                doWork(person1);
            }

           // doWork(person); //вызываем doWork


    }

    public static void doWork(Person person) {
        // пункт 3
        if (person instanceof Person.User) ((Person.User) person).live();
        if (person instanceof Person.Loser) ((Person.Loser) person).doNothing();
        if (person instanceof Person.Coder) ((Person.Coder) person).coding();
        if (person instanceof  Person.Proger) ((Person.Proger) person).enjoy();
    }
}
