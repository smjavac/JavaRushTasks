package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        try (BufferedReader bReader = new BufferedReader(new FileReader(args[0]))) {
            String name;
            String date;
            SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            while (bReader.ready()) {
                String line = bReader.readLine();
                name = line.replaceAll("\\d", "").trim();
                date = line.replace(name, "").trim();
                PEOPLE.add(new Person(name, sdf.parse(date)));
            }
            for (Person p : PEOPLE) {
                System.out.println(p.getName() + " " + p.getBirthday());
            }
        }
    }
}

//           while (bReader.ready()){
//               String [] s1 = bReader.readLine().split(" ");
//               StringBuilder name1 = new StringBuilder();
//               int year1 = Integer.parseInt(s1[s1.length - 1]);
//               int month1 = Integer.parseInt(s1[s1.length - 2]);
//               int day1 = Integer.parseInt(s1[s1.length - 3]);
//
//               for (int i = 0; i < s1.length; i++){
//                    try {                                             // РАБОЧИЙ КОД, НО НЕ ПРОХОДИТ ВАЛИДАЦИЮ
//                       Integer.parseInt(s1[i]);
//                    }  catch (NumberFormatException e){
//                       name1.append(s1[i] + " ");
//                       }
//               }
//               Date date1 = new Date(year1- 1900, month1 - 1, day1);
//               Person person = new Person(name1.toString(), date1);
//             //  PEOPLE.add(new Person(name1.toString(), date1));
//               PEOPLE.add(person);
//           }
//       }


