package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        String name;
        int id;
        Sex sex;
        Date birsday;
        Person p;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        if (args[0].equals("-c")){
            name = args[1];
            sex = (args[2] == "м") ? Sex.MALE : Sex.FEMALE;
            birsday = sdf.parse(args[3]);
            if (sex == Sex.MALE) p = Person.createMale(name,birsday);
            else p = Person.createFemale (name, birsday);
            allPeople.add(p);
            System.out.println(allPeople.indexOf(p));
        }else if (args[0].equals("-u")){
            id = Integer.parseInt(args[1]);
            allPeople.get(id).setName(args[2]);
            allPeople.get(id).setSex(sex = args[3].equals("м")? Sex.MALE :  Sex.FEMALE );
            allPeople.get(id).setBirthDay(sdf.parse(args[4]));
        }else if (args[0].equals("-d")){
            id = Integer.parseInt(args[1]);
            allPeople.get(id).setName(null);
            allPeople.get(id).setSex(null);
            allPeople.get(id).setBirthDay(null);
        }else if (args[0].equals("-i")){
            id = Integer.parseInt(args[1]);
            String sx = (allPeople.get(id).getSex() == Sex.MALE)? "м" : "ж";
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH);
            System.out.println(allPeople.get(id).getName() + " " + sx + " " + sdf2.format(allPeople.get(id).getBirthDay()));
        }
    }
}
