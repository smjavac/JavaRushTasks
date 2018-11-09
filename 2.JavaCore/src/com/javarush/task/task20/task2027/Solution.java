package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
              /* 0*/ {'f', 'd', 'e', 'r', 'l', 'k'},
              /* 1*/ {'u', 's', 'a', 'm', 'e', 'o'},
              /* 2*/ {'l', 'n', 'g', 'r', 'o', 'v'},
              /* 3*/ {'m', 'l', 'p', 'r', 'r', 'h'},
              /* 4*/ {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home","same","lp","l");
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
            text = s;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < crossword.length; i++){
                for (int j = 0; j < crossword[i].length; j++) {
                    if ((char)crossword[i][j] == text.charAt(0)) {
                             System.out.println("первое вхождение");
                             char ch = (char) crossword[i][j];
                             if(text.length()==1){
                                 System.out.println("это сообщение когда слово из одной буквы ");
                                 stringBuilder.setLength(0);
                                 stringBuilder = stringBuilder.append(ch);
                                 startX = j;
                                 startY = i;
                                 endX = startX;
                                 endY = startY;
                                 if (text.equals(stringBuilder.toString())){
                                     word = new Word(text);
                                     word.setStartPoint(startX, startY);
                                     word.setEndPoint(endX, endY);
                                     list.add(word);
                                 }
                                 break;
                             }

                                startX = j;
                                startY = i;
                        System.out.println(startX);
                        System.out.println(startY);
                              //  endX = 0;
                              //  endY = 0;
                        try {
                            if ((char)crossword[i][j+1] == text.charAt(1)) {
                                   System.out.println("первый if");
                                stringBuilder.setLength(0);
                                stringBuilder = stringBuilder.append(ch).append((char) crossword[i][j+1]);
                                endX= j+1;
                                endY=i;
                                for (int k = 2; k < text.length(); k++) {
                                    stringBuilder = stringBuilder.append((char) crossword[i][j + k]);
                                    endX = j + k;
                                    endY = i;
                                }
                                if (text.equals(stringBuilder.toString())){
                                    word = new Word(text);
                                    word.setStartPoint(startX, startY);
                                    word.setEndPoint(endX, endY);
                                    list.add(word);
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException e){
                                   System.out.println("ошибка в первом if");
                        }
                        try {
                            if ((char) crossword[i][j - 1] == text.charAt(1)) {
                                       System.out.println("второй if");
                                stringBuilder.setLength(0);
                                stringBuilder = stringBuilder.append(ch).append((char) crossword[i][j - 1]);
                                endX=j-1;
                                endY=i;
                                for (int k = 2; k < text.length(); k++) {
                                    stringBuilder = stringBuilder.append((char) crossword[i][j - k]);
                                    endX = j - k;
                                    endY = i;
                                }
                                if (text.equals(stringBuilder.toString())){
                                    word = new Word(text);
                                    word.setStartPoint(startX, startY);
                                    word.setEndPoint(endX, endY);
                                    list.add(word);
                                }
                            }
                        }catch (ArrayIndexOutOfBoundsException e){
                                   System.out.println("ошибка во втором if");
                        }
                        try {
                            if ((char) crossword[i - 1][j] == text.charAt(1)) {
                                       System.out.println("третий if");
                                stringBuilder.setLength(0);
                                stringBuilder = stringBuilder.append(ch).append((char) crossword[i - 1][j]);
                                endX=j;
                                endY=i-1;
                                for (int k = 2; k < text.length(); k++) {
                                    stringBuilder = stringBuilder.append((char) crossword[i - k][j]);
                                    endX = j;
                                    endY = i - k;
                                }
                                if (text.equals(stringBuilder.toString())){
                                    word = new Word(text);
                                    word.setStartPoint(startX, startY);
                                    word.setEndPoint(endX, endY);
                                    list.add(word);
                                }
                            }
                        }catch (ArrayIndexOutOfBoundsException e){
                                   System.out.println("ошибка в третьем if");
                        }
                        try {
                            if ((char) crossword[i + 1][j] == text.charAt(1)) {
                                        System.out.println("четвертый if");
                                stringBuilder.setLength(0);
                                stringBuilder = stringBuilder.append(ch).append((char) crossword[i + 1][j]);
                                endX=j;
                                endY=i+1;
                                for (int k = 2; k < text.length(); k++) {
                                    stringBuilder = stringBuilder.append((char) crossword[i + k][j]);
                                    endX = j;
                                    endY = i + k;
                                }
                                if (text.equals(stringBuilder.toString())){
                                    word = new Word(text);
                                    word.setStartPoint(startX, startY);
                                    word.setEndPoint(endX, endY);
                                    list.add(word);
                                }
                            }
                        }catch (ArrayIndexOutOfBoundsException e){
                                System.out.println("ошибка в четвертом if");
                        }
                        try {
                            if ((char) crossword[i + 1][j + 1] == text.charAt(1)) {
                                        System.out.println("пятый if");
                                stringBuilder.setLength(0);
                                stringBuilder = stringBuilder.append(ch).append((char) crossword[i + 1][j + 1]);
                                endX=j+1;
                                endY=i+1;
                                for (int k = 2; k < text.length(); k++) {
                                    stringBuilder = stringBuilder.append((char) crossword[i + k][j + k]);
                                    endX = j + k;
                                    endY = i + k;
                                }
                                if (text.equals(stringBuilder.toString())){
                                    word = new Word(text);
                                    word.setStartPoint(startX, startY);
                                    word.setEndPoint(endX, endY);
                                    list.add(word);
                                }
                            }
                        }catch (ArrayIndexOutOfBoundsException e){
                                 System.out.println("ошибка в пятом if");
                        }
                        try {
                            if ((char) crossword[i - 1][j - 1] == text.charAt(1)) {
                                       System.out.println("шестой if");
                                stringBuilder.setLength(0);
                                stringBuilder = stringBuilder.append(ch).append((char) crossword[i - 1][j - 1]);
                                endX=j-1;
                                endY=i-1;
                                for (int k = 2; k < text.length(); k++) {
                                    stringBuilder = stringBuilder.append((char) crossword[i - k][j - k]);
                                    endX = j - k;
                                    endY = i - k;
                                }
                                if (text.equals(stringBuilder.toString())){
                                    word = new Word(text);
                                    word.setStartPoint(startX, startY);
                                    word.setEndPoint(endX, endY);
                                    list.add(word);
                                }
                            }
                        }catch (ArrayIndexOutOfBoundsException e){
                                 System.out.println("ошибка в шестом if");
                        }
                        try {
                            if ((char) crossword[i - 1][j + 1] == text.charAt(1)) {
                                    System.out.println("седьмой if");
                                stringBuilder.setLength(0);
                                stringBuilder = stringBuilder.append(ch).append((char) crossword[i - 1][j + 1]);
                                endX=j+1;
                                endY=i-1;
                                for (int k = 2; k < text.length(); k++) {
                                    stringBuilder = stringBuilder.append((char) crossword[i - k][j + k]);
                                    endX = j + k;
                                    endY = i - k;
                                }
                                if (text.equals(stringBuilder.toString())){
                                    word = new Word(text);
                                    word.setStartPoint(startX, startY);
                                    word.setEndPoint(endX, endY);
                                    list.add(word);
                                }
                            }
                        }catch (ArrayIndexOutOfBoundsException e){
                                 System.out.println("ошибка в седьмом if");
                        }
                        try {
                            if ((char)crossword[i+1][j-1] == text.charAt(1)) {
                                      System.out.println("восьмой if");
                                stringBuilder.setLength(0);
                                stringBuilder = stringBuilder.append(ch).append((char) crossword[i+1][j-1]);
                                endX=j-1;
                                endY=i+1;
                                for (int k = 2; k < text.length(); k++) {
                                    stringBuilder = stringBuilder.append((char) crossword[i+k][j-k]);
                                    endX = j-k;
                                    endY = i+k;
                                }
                                if (text.equals(stringBuilder.toString())){
                                    word = new Word(text);
                                    word.setStartPoint(startX, startY);
                                    word.setEndPoint(endX, endY);
                                    list.add(word);
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                                  System.out.println("ошибка в восьмом if");
                        }
                    }
                }
            }

              System.out.println("это вызов методы stringBuilder.toString: " + stringBuilder.toString());
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
