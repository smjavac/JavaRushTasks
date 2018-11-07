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

    public static List<Word> detectAllWords(int[][] crossword, String... words)  {
           // String [] strings = words.clone();
        List<Word> list = new ArrayList<>();

        String text;
        Word word;
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;
            char [][] chars = new char[crossword.length + 1][crossword[0].length+1];
             for (int i = 0; i < crossword.length; i++){
                for (int j = 0; j < crossword[i].length; j++){
                    chars[i][j] = (char) crossword[i][j];

                }
             }

             for (String s: words){
                 text = s;
               //    int texsLength = text.length()-1;                                                          //'f', 'd', 'e', 'r', 'l', 'k'
              //   char [] ch = text.toCharArray();                                                          // 'u', 's', 'a', 'm', 'e', 'o'
           //      for (int k = 0; k < text.length(); k++) {                                                 // 'l', 'n', 'g', 'r', 'o', 'v'
                   StringBuilder stringBuilder = new StringBuilder();                                       // 'm', 'l', 'p', 'r', 'r', 'h'
                    for (int i = 0; i < crossword.length; i++){                                                // 'p', 'o', 'e', 'e', 'j', 'j'
                        for (int j = 0; j < crossword[i].length; j++) {

                            if ((char)crossword[i][j] == text.toCharArray()[0]) {
                                System.out.println("первое вхождение");
                                stringBuilder = stringBuilder.append((char) crossword[i][j]);
                                startX = j;
                                startY = i;
                                try {
                                    if ((char)crossword[i][j+1] == text.toCharArray()[1]) {
                                        System.out.println("первый if");
                                        stringBuilder = stringBuilder.append((char) crossword[i][j+1]);
                                        for (int k = 2; k < text.length(); k++) {
                                            stringBuilder = stringBuilder.append((char) crossword[i][j+k]);
                                            endX = j+k;
                                            endY = i;
                                        }
                                    }
                                    if ((char)crossword[i][j - 1] == text.toCharArray()[1]) {
                                        System.out.println("второй if");
                                        stringBuilder = stringBuilder.append((char) crossword[i][j-1]);
                                        for (int k = 2; k < text.length(); k++) {
                                            stringBuilder = stringBuilder.append((char) crossword[i][j-k]);
                                            endX = j-k;
                                            endY = i;
                                        }
                                    }
                                    if ((char)crossword[i-1][j] == text.toCharArray()[1]) {
                                        System.out.println("третий if");
                                        stringBuilder = stringBuilder.append((char) crossword[i-1][j]);
                                        for (int k = 2; k < text.length(); k++) {
                                            stringBuilder = stringBuilder.append((char) crossword[i-k][j]);
                                            endX = j;
                                            endY = i-k;
                                        }
                                    }
                                    if ((char)crossword[i+1][j] == text.toCharArray()[1]) {
                                        System.out.println("четвертый if");
                                        stringBuilder = stringBuilder.append((char) crossword[i+1][j]);
                                        for (int k = 2; k < text.length(); k++) {
                                            stringBuilder = stringBuilder.append((char) crossword[i+k][j]);
                                            endX = j;
                                            endY = i+k;
                                        }
                                    }
                                    if ((char)crossword[i+1][j+1] == text.toCharArray()[1]) {
                                        System.out.println("пятый if");
                                        stringBuilder = stringBuilder.append((char) crossword[i+1][j+1]);
                                        for (int k = 2; k < text.length(); k++) {
                                            stringBuilder = stringBuilder.append((char) crossword[i+k][j+k]);
                                            endX = j+k;
                                            endY = i+k;
                                        }
                                    }
                                    if ((char)crossword[i-1][j-1] == text.toCharArray()[1]) {
                                        System.out.println("шестой if");
                                        stringBuilder = stringBuilder.append((char) crossword[i-1][j-1]);
                                        for (int k = 2; k < text.length(); k++) {
                                            stringBuilder = stringBuilder.append((char) crossword[i-k][j-k]);
                                            endX = j-k;
                                            endY = i-k;
                                        }
                                    }
                                    if ((char)crossword[i-1][j+1] == text.toCharArray()[1]) {
                                        System.out.println("седьмой if");
                                        stringBuilder = stringBuilder.append((char) crossword[i-1][j+1]);
                                        for (int k = 2; k < text.length(); k++) {
                                            stringBuilder = stringBuilder.append((char) crossword[i-k][j+k]);
                                            endX = j+k;
                                            endY = i-k;
                                        }
                                    }
                                    if ((char)crossword[i+1][j-1] == text.toCharArray()[1]) {
                                        System.out.println("восьмой if");
                                        stringBuilder = stringBuilder.append((char) crossword[i+1][j-1]);
                                        for (int k = 2; k < text.length(); k++) {
                                            stringBuilder = stringBuilder.append((char) crossword[i+k][j-k]);
                                            endX = j-k;
                                            endY = i+k;
                                        }
                                    }
                                } catch (ArrayIndexOutOfBoundsException e) {

                                    break;
                                }
                            }
                        }
                    }
                    if (text.equals(stringBuilder.toString())){
                        word = new Word(text);
                        word.setStartPoint(startX, startY);
                        word.setEndPoint(endX, endY);
                        list.add(word);
                    }
               //  System.out.println(text);
                 System.out.println("это вызов методы stringBuilder.toString: " + stringBuilder.toString());
             }
             for (Word w : list) System.out.println(w);
        return list;
        }

      //  list.add(new Word(text));



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
