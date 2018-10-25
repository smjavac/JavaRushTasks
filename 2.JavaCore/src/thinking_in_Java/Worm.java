package thinking_in_Java;

import java.io.*;
import java.util.*;


class Data {
    private int n;
    public Data(int n) { this.n = n; }
    public String toString() { return Integer.toString(n); }
}

public class Worm  {
   // private static Random rand = new Random(47);
    public Data[] d = {new Data(1), new Data(2), new Data(3)
    };
    private Worm next;
    private char c;
    // Value of i == number of segments
    public Worm(int i, char x) {
        System.out.println("Worm constructor: " + i);
        c = x;
        if(--i > 0)
            next = new Worm(i, (char)(x + 1));
    }
    public Worm() {
        System.out.println("Default constructor");
    }
 //   public String toString() {
//        StringBuilder result = new StringBuilder(":");
//        result.append(c);
//        result.append("(");
//        for(Data dat : d)
//            result.append(dat);
//        result.append(")");
//        if(next != null)
//            result.append(next);
//        return result.toString();
//    }
    public static void main(String[] args){
        Worm w = new Worm(2, 'a');

    }
}
