package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Externalizable Person
*/
public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(){
            super();
        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeInt(age);
            out.writeObject(children);
            out.writeObject(firstName);
            out.writeObject(lastName);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            age = in.readInt();
            children = (List<Person>)in.readObject();
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();


        }


    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        FileOutputStream fos = new FileOutputStream("D:\\java\\IDEA\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2013\\file");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        Person person1 = new Person("person1", "person1", 30);
//        person1.setMother(new Person("мама", "мама", 55));
//        person1.setFather(new Person("папа", " папа", 60));
//        List<Person> children = new ArrayList<>();
//        children.add(new Person("child1", "child1", 10));
//        person1.setChildren(children);
//        oos.writeObject(person1);
//        FileInputStream fis = new FileInputStream("D:\\java\\IDEA\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2013\\file");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        Person person2 = (Person)ois.readObject();
//
//        System.out.println(person1.equals(person2));

    }
}

