package com.javarush.task.task20.task2007;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Как сериализовать JavaRush?
*/
public class Solution {
    public static class JavaRush implements Serializable {
        public List<User> users = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        // код ниже для проверки, нужна ли сериализация класса Uzer
//        JavaRush javaRush = new JavaRush();
//        User user = new User();
//        user.setBirthDate(new Date());
//        javaRush.users.add(user);
//        FileOutputStream fileOutputStream = new FileOutputStream("D:\\java\\IDEA\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2007\\file");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        for (User u: javaRush.users) objectOutputStream.writeObject(u);
    }
}
