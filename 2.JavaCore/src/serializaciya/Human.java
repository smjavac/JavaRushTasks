package serializaciya;

import java.io.*;

public class Human {
    public Cat cat;
    public Dog dog;

    public void save(PrintWriter writer) throws Exception {
        String isCatPresent = cat != null ? "yes" : "no";
        writer.println(isCatPresent);
        writer.flush();

        if (cat != null)
            cat.save(writer);

        String isDogPresent = dog != null ? "yes" : "no";
        writer.println(isDogPresent);
        writer.flush();

        if (dog != null)
            dog.save(writer);
    }

    public void load(BufferedReader reader) throws Exception {

        String isCatPresent = reader.readLine();
        if (isCatPresent.equals("yes")) {
            cat = new Cat();
            cat.load(reader);
        }

        String isDogPresent = reader.readLine();
        if (isDogPresent.equals("yes")) {
            dog = new Dog();
            dog.load(reader);
        }
    }

  static  class Dog {
        public String name;
        public int age;

        public void save(PrintWriter writer) throws Exception {
            writer.println(name);
            writer.println(age);
            writer.flush();
        }

        public void load(BufferedReader reader) throws Exception {
            name = reader.readLine();
            age = Integer.parseInt(reader.readLine());
        }
    }

    static class Cat {
        public String name;
        public int age;
        public int weight;

        public void save(PrintWriter writer) throws Exception {
            writer.println(name);
            writer.println(age);
            writer.println(weight);
            writer.flush();
        }

        public void load(BufferedReader reader) throws Exception {
            name = reader.readLine();
            age = Integer.parseInt(reader.readLine());
            weight = Integer.parseInt(reader.readLine());
        }
    }
    public static void main(String[] args) throws Exception{
        OutputStream outputStream = new FileOutputStream("D:\\java\\IDEA\\JavaRushTasks\\2.JavaCore\\src\\serializaciya\\file");
        InputStream inputStream = new FileInputStream("D:\\java\\IDEA\\JavaRushTasks\\2.JavaCore\\src\\serializaciya\\file");

        Human human = new Human();
        human.cat = new Cat();
        human.save(new PrintWriter(outputStream));
       // human.load(new BufferedReader(new InputStreamReader(inputStream)));
        outputStream.close();
        inputStream.close();
    }

}
