package com.javarush.task.task21.task2109;

import java.util.Objects;

/*
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof A)) return false;
            A a = (A) o;
            return i == a.i &&
                    j == a.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        protected B clone() throws CloneNotSupportedException{
            throw new CloneNotSupportedException();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof B)) return false;
            B b = (B) o;
            return Objects.equals(name, b.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected C clone() throws CloneNotSupportedException {
           C c = new C(getI(),getJ(), getName());
            return c;
        }

        @Override
        public boolean equals(Object o) {
            return super.equals(o);
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }

    public static void main(String[] args) {
        B b = new B(1, 2, "said");
        try {
            B clone = b.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("ошибка в методе clone() класса B");
        }

        A a = new A(3,4);
        try {
            A clone = (A) a.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("ошибка в методе clone() класса А");
        }

        C c = new C(5,6, "zaur");
        try {
            C clone = (C) c.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("ошибка в методе clone() класса С");
        }
    }
}
