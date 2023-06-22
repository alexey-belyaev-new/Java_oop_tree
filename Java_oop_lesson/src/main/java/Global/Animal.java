package Global;

import Human.Human;

public interface Animal {
    String getName();

    Human getFather();

     Human getMother();

    String getInfoHuman();

    void addChild(Human child);

    Integer getAge();
}
