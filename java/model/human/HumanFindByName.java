package model.human;

import model.famalyTree.Animal;

import java.util.Comparator;

public class HumanFindByName<T extends Animal> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
