package com.company;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private int weight = 0;
    private int price = 0;
    private int capacity;
    private List<Subject> subjectsBackpack = new ArrayList<>();
    private static List<Subject> subjectsList = new ArrayList<>();
    private ArrayList<Integer> indexes = new ArrayList<>();

    Backpack(int capacity) {
        this.capacity = capacity;
    }

    void optimalLoad() {
        backpackLoad(indexes, weight, price);
        for (int value : indexes
                ) {
            subjectsBackpack.add(subjectsList.get(value));
        }
    }

    private void backpackLoad(ArrayList<Integer> preIndexes, int preWeight, int prePrice) {
        for (int i = 0; i < subjectsList.size(); i++) {
            if (preIndexes.indexOf(i) != -1) {
                continue;
            }
            ArrayList<Integer> indexesCopy = new ArrayList<>(preIndexes);
            int priceCopy = prePrice;
            int weightCopy = preWeight;
            priceCopy += subjectsList.get(i).getPrice();
            weightCopy += subjectsList.get(i).getCapacity();
            indexesCopy.add(i);
            if (weightCopy < capacity) {
                if (subjectsList.size() > indexesCopy.size()) {
                    backpackLoad(indexesCopy, weightCopy, priceCopy);
                } else {
                    price = priceCopy;
                    weight = weightCopy;
                    indexes = indexesCopy;
                }
            } else {
                if (price < prePrice) {
                    price = prePrice;
                    weight = preWeight;
                    indexes = preIndexes;
                }
            }
        }
    }

    static void addSubjectsList(Subject subject) {
        subjectsList.add(subject);
    }

    @Override
    public String toString() {
        return "Backpack{" +
                "weight=" + weight +
                ", price=" + price + "\n" +
                "subjectsBackpack=" + subjectsBackpack +
                '}';
    }
}
