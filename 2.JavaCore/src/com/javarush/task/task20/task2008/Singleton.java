package com.javarush.task.task20.task2008;

import java.io.*;

public class Singleton implements Serializable {

    private static Singleton singleton = new Singleton( );

    public int i = 1;

    private Singleton() { }

    public static Singleton getInstance( ) {

        return singleton;
    }

    public Object readResolve() {
        return getInstance( );
    }

//    public static void main(String[] args) {
//        Singleton s1 = getInstance();
//        System.out.println(s1.hashCode());
//
//        Singleton s2 = getInstance();
//        System.out.println(s2.hashCode());
//    }
}
 class SingletonSerializableDemo {

    static Singleton sing = Singleton.getInstance();
    static Singleton s1  = null;
    static Singleton s2 = null;
    public static void main(String[] args) {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("D:\\java\\IDEA\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2008\\file");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(sing);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved");

            FileInputStream fileIn1 = new FileInputStream("D:\\java\\IDEA\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2008\\file");
            FileInputStream fileIn2 = new FileInputStream("D:\\java\\IDEA\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2008\\file");
            ObjectInputStream in1 = new ObjectInputStream(fileIn1);
            ObjectInputStream in2 = new ObjectInputStream(fileIn2);
            s1 = (Singleton) in1.readObject();
            s2 = (Singleton) in2.readObject();
            System.out.println(s1.hashCode() + " "+ s1.i);
            s1.i = 10;
            System.out.println(s2.hashCode() + " "+ s2.i);
            in1.close();
            in2.close();
            fileIn1.close();
            fileIn2.close();
        }catch(Exception i) {
            i.printStackTrace();
        }
    }
}