package model.famalyTree;

import model.human.Human;

public interface Animal {
    String getName();

    Human getFather();

     Human getMother();

    String getInfoHuman();

    void addChild(Animal child);

    Integer getAge();
}
