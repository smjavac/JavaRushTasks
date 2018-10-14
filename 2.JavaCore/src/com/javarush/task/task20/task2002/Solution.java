package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("D:\\java\\IDEA\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2002\\file");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("firstname");
            user.setLastName("Lastname");
            user.setCountry(User.Country.OTHER);
            user.setMale(true);
            user.setBirthDate(new Date(80,5,7));
            javaRush.users.add(user);
            user = new User();
            user.setFirstName("firstname2");
            user.setLastName("Lastname2");
            user.setCountry(User.Country.UKRAINE);
            user.setMale(true);
            user.setBirthDate(new Date(81,3,8));
            javaRush.users.add(user);


            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            for (User user : users){
                printWriter.println(user.getFirstName());
                printWriter.println(user.getLastName());
                printWriter.println(user.getCountry());
                printWriter.println(String.valueOf(user.isMale()));
                printWriter.println(user.getBirthDate());


            }
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            SimpleDateFormat myDateFormat = new SimpleDateFormat( "EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

            User u;
            while (br.ready()){
                u = new User();
                u.setFirstName(br.readLine());
                u.setLastName(br.readLine());
                u.setCountry(User.Country.valueOf(br.readLine()));
                u.setMale(Boolean.valueOf(br.readLine()));
                u.setBirthDate(myDateFormat.parse(br.readLine()));
                users.add(u);
            }

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}