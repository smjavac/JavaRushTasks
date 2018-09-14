package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
        System.out.println(hen.getDescription());
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            //напишите тут ваш код
            if (country.equals(Country.RUSSIA))
               hen = new RussianHen();
            else if (country.equals(Country.BELARUS))
                hen = new BelarusianHen();
            else if (country.equals(Country.MOLDOVA))
                hen = new MoldovanHen();
            else if (country.equals(Country.UKRAINE))
                hen = new UkrainianHen();
            return hen;
        }
    }
     /*static abstract class Hen {

         abstract int getCountOfEggsPerMonth();

         String getDescription(){
            return "Я - курица.";
         }

    }*/

   /* static class RussianHen1 extends Hen {
        int getCountOfEggsPerMonth() {
            return 0;
        }
    }

    static class UkrainianHen1 extends Hen {
        int getCountOfEggsPerMonth() {
            return 0;
        }
    }

    static class MoldovanHen1 extends Hen {
        int getCountOfEggsPerMonth() {
            return 0;
        }
    }

    static class BelarusianHen1 extends Hen {
        int getCountOfEggsPerMonth() {
            return 0;
        }
    }*/







}
