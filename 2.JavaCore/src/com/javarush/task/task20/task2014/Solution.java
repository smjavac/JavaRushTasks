package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

    //    System.out.println(new Solution(4));

        Solution savedObject = new Solution(15);
        FileOutputStream fos = new FileOutputStream("D:\\java\\IDEA\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2014\\file");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(savedObject);
        oos.flush();
        fos.close();
        oos.close();
        FileInputStream fis = new FileInputStream("D:\\java\\IDEA\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2014\\file");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Solution loadedObject = (Solution) ois.readObject();
        fis.close();
        ois.close();
//        System.out.println(savedObject.string);
//        System.out.println(savedObject.pattern);
//        System.out.println(savedObject.temperature);
//        System.out.println(savedObject.currentDate);
//        System.out.println(loadedObject.string);
//        System.out.println(loadedObject.pattern);
//        System.out.println(loadedObject.temperature);
//        System.out.println(loadedObject.currentDate);
        System.out.println(loadedObject.string.equals(savedObject.string));
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
