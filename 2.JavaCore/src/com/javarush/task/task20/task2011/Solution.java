package com.javarush.task.task20.task2011;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
Externalizable для апартаментов
*/
public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
        }

        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
           address = (String) in.readObject();
           year = in.readInt();
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }
    }

    public static void main(String[] args) throws IOException {
      //  String content = new String(Files.readAllBytes(Paths.get(args[0])));
    }
}
