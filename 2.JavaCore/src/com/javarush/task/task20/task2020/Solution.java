package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/
public class Solution {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String  fullName;
        final transient String greeting;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greeting = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\java\\IDEA\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2020\\file"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\java\\IDEA\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2020\\file"))){
            Person person1 = new Person("firsname","lastname", "russia", Sex.MALE);
            oos.writeObject(person1);
            Person person2 = (Person) ois.readObject();
            System.out.println(person2.fullName);
        }


    }
}
