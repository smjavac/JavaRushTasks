package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse>  horses;

    static Hippodrome game;

    public void run(){
        for( int i = 0; i < 100; i++){
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for (Horse horse : horses){
            horse.move();
            horse.print();
        }
    }

    public void print() {
        for (Horse horse : horses){
            horse.print();
        }
        for (int i = 0; i < 10; i++)
            System.out.println("");
    }

        public Horse getWinner() {
        int dist = (int) horses.get(0).distance;
        Horse hors = horses.get(0);
            for (int i = 1; i < horses.size(); i++){
                if ( dist < (int)horses.get(i).distance){
                    dist = (int)horses.get(i).distance;
                    hors = horses.get(i);
                }
            }
         return hors;
        }

        public void printWinner() {
            System.out.println("Winner is " + getWinner().getName()+ "!");
        }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());
        Horse horse1 = new Horse("horse1", 3, 0);
        Horse horse2 = new Horse("horse2", 3, 0);
        Horse horse3 = new Horse("horse3", 3, 0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();

    }
}
