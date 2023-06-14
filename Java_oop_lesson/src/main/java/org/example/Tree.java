package org.example;

import java.io.Serializable;
import java.util.*;

public class Tree implements Serializable, Iterable<Human> {
    private List<Human> list;

    public Tree() {
        list = new ArrayList<>();
    }
    public void addHuman(Human human){
        if(!list.contains(human)){
            list.add(human);
            if (human.getFather() != null){
                human.getFather().addChild(human);
            }
            if (human.getMother() != null){
                human.getMother().addChild(human);
            }

        }
    }
    public String find(String name){
        StringBuffer sb = new StringBuffer();
        for (Human human: list) {
            if(human.getName().equalsIgnoreCase(name)){
                sb.append(human.getInfoHuman());
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    public Human getName(String name){
        for (Human human:list) {
            if(human.getName().equalsIgnoreCase(name)){
                return human;
            }
        }
        return null;
    }
    public String getInfo(){
        StringBuffer sb = new StringBuffer();
        for (Human human:list) {
            sb.append(human.getInfoHuman());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return list.iterator();
    }
    public void sortByName(){
        list.sort(new HumanFindByName());
    }
    public void sortByAge(){
        list.sort(new HumanFindByAge());
    }
}
