package com.company;

public class Main {
    public static void main(String[] args) {
        Subject subject1 = new Subject(15,60);
        Subject subject2 = new Subject(30,90);
        Subject subject3 = new Subject(50,100);
        Backpack backpack = new Backpack(80);
        backpack.optimalLoad();
        System.out.println(backpack.toString());
    }
}
