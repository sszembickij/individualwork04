package com.company;

public class Subject {
    private int capacity;
    private int price;

    Subject(int capacity, int price) {
        this.capacity = capacity;
        this.price = price;
        Backpack.addSubjectsList(this);
    }

    int getCapacity() {
        return capacity;
    }

    int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "{capacity=" + capacity + ", price=" + price + '}';
    }
}
