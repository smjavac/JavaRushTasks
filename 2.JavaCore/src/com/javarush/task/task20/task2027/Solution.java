package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
           // String [] strings = words.clone();
        List<Word> list = new ArrayList<>();
        String text;
        int startX;
        int startY;
        int endX;
        int endY;
            char [][] chars = new char[crossword.length + 1][crossword[0].length+1];
             for (int i = 0; i < crossword.length; i++){
                for (int j = 0; j < crossword[i].length; j++){
                    chars[i][j] = (char) crossword[i][j];

                }
             }

             for (String s: words){
                 text = s;                                             //'f', 'd', 'e', 'r', 'l', 'k'
              //   char [] ch = text.toCharArray();                    // 'u', 's', 'a', 'm', 'e', 'o'
             //    for (int i = 0; i < ch.length; i++) {               // 'l', 'n', 'g', 'r', 'o', 'v'
                    for (int i = 0; i < chars.length; i++){            // 'm', 'l', 'p', 'r', 'r', 'h'
                        for (int j = 0; j < chars[i].length; j++){     // 'p', 'o', 'e', 'e', 'j', 'j'
                            if (crossword[i][j] == text.indexOf(crossword[i][j],0)){
                                try {
                                    if (crossword[i-1][j-1] == text.indexOf(crossword[i][j],1)){

                                    }
                                }catch (ArrayIndexOutOfBoundsException e){

                                }
                            }
                        }
                    }
          //     }
             }
      //  list.add(new Word(text));
        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
