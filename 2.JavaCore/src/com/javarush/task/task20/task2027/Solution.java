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
        List<Word> list = new ArrayList<>();

        String text;
        Word word;
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;
              for (String s: words){
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < crossword.length; i++){
                        for (int j = 0; j < crossword[i].length; j++) {

                            if ((char)crossword[i][j] == s.charAt(0)) {
                           //     System.out.println("первое вхождение");
                                stringBuilder = stringBuilder.append((char) crossword[i][j]);
                                startX = j;
                                startY = i;                                                                             //'f', 'd', 'e', 'r', 'l', 'k'
                                endX = 0;                                                                               // 'u', 's', 'a', 'm', 'e', 'o'
                                endY = 0;                                                                               // 'l', 'n', 'g', 'r', 'o', 'v'
                                try {
                                    if ((char)crossword[i][j+1] == s.charAt(1)) {
                                     //   System.out.println("первый if");
                                        stringBuilder = stringBuilder.append((char) crossword[i][j+1]);
                                        for (int k = 2; k < s.length(); k++) {
                                            stringBuilder = stringBuilder.append((char) crossword[i][j + k]);
                                            endX = j + k;
                                            endY = i;
                                        }
                                    }
                                } catch (ArrayIndexOutOfBoundsException e){
                             //       System.out.println("ошибка в первом if");
                                }
                                try {
                                    if ((char) crossword[i][j - 1] == s.charAt(1)) {
                                 //       System.out.println("второй if");
                                        stringBuilder = stringBuilder.append((char) crossword[i][j - 1]);
                                        for (int k = 2; k < s.length(); k++) {
                                            stringBuilder = stringBuilder.append((char) crossword[i][j - k]);
                                            endX = j - k;
                                            endY = i;
                                        }
                                    }
                                }catch (ArrayIndexOutOfBoundsException e){
                             //       System.out.println("ошибка во втором if");
                                }
                                try {
                                    if ((char) crossword[i - 1][j] == s.charAt(1)) {
                                 //       System.out.println("третий if");
                                        stringBuilder = stringBuilder.append((char) crossword[i - 1][j]);
                                        for (int k = 2; k < s.length(); k++) {
                                            stringBuilder = stringBuilder.append((char) crossword[i - k][j]);
                                            endX = j;
                                            endY = i - k;
                                        }
                                    }
                                }catch (ArrayIndexOutOfBoundsException e){
                             //       System.out.println("ошибка в третьем if");
                                }
                                try {
                                    if ((char) crossword[i + 1][j] == s.charAt(1)) {
                                //        System.out.println("четвертый if");
                                        stringBuilder = stringBuilder.append((char) crossword[i + 1][j]);
                                        for (int k = 2; k < s.length(); k++) {
                                            stringBuilder = stringBuilder.append((char) crossword[i + k][j]);
                                            endX = j;
                                            endY = i + k;
                                        }
                                    }
                                }catch (ArrayIndexOutOfBoundsException e){
                                //    System.out.println("ошибка в четвертом if");
                                }
                                try {
                                    if ((char) crossword[i + 1][j + 1] == s.charAt(1)) {
                                //        System.out.println("пятый if");
                                        stringBuilder = stringBuilder.append((char) crossword[i + 1][j + 1]);
                                        for (int k = 2; k < s.length(); k++) {
                                            stringBuilder = stringBuilder.append((char) crossword[i + k][j + k]);
                                            endX = j + k;
                                            endY = i + k;
                                        }
                                    }
                                }catch (ArrayIndexOutOfBoundsException e){
                               //     System.out.println("ошибка в пятом if");
                                }
                                try {
                                    if ((char) crossword[i - 1][j - 1] == s.charAt(1)) {
                                 //       System.out.println("шестой if");
                                        stringBuilder = stringBuilder.append((char) crossword[i - 1][j - 1]);
                                        for (int k = 2; k < s.length(); k++) {
                                            stringBuilder = stringBuilder.append((char) crossword[i - k][j - k]);
                                            endX = j - k;
                                            endY = i - k;
                                        }
                                    }
                                }catch (ArrayIndexOutOfBoundsException e){
                               //     System.out.println("ошибка в шестом if");
                                }
                                try {
                                    if ((char) crossword[i - 1][j + 1] == s.charAt(1)) {
                                    //    System.out.println("седьмой if");
                                        stringBuilder = stringBuilder.append((char) crossword[i - 1][j + 1]);
                                        for (int k = 2; k < s.length(); k++) {
                                            stringBuilder = stringBuilder.append((char) crossword[i - k][j + k]);
                                            endX = j + k;
                                            endY = i - k;
                                        }
                                    }
                                }catch (ArrayIndexOutOfBoundsException e){
                               //     System.out.println("ошибка в седьмом if");
                                }
                                try {
                                    if ((char)crossword[i+1][j-1] == s.charAt(1)) {
                                  //      System.out.println("восьмой if");
                                        stringBuilder = stringBuilder.append((char) crossword[i+1][j-1]);
                                        for (int k = 2; k < s.length(); k++) {
                                            stringBuilder = stringBuilder.append((char) crossword[i+k][j-k]);
                                            endX = j-k;
                                            endY = i+k;
                                        }
                                    }
                                } catch (ArrayIndexOutOfBoundsException e) {
                              //      System.out.println("ошибка в восьмом if");
                                }
                            }
                        }
                    }
                    if (s.equals(stringBuilder.toString())){
                        word = new Word(s);
                        word.setStartPoint(startX, startY);
                        word.setEndPoint(endX, endY);
                        list.add(word);
                    }
               //  System.out.println("это вызов методы stringBuilder.toString: " + stringBuilder.toString());
              }
             for (Word w : list) System.out.println(w);
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
