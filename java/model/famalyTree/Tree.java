package model.famalyTree;

import model.human.HumanFindByAge;
import model.human.HumanFindByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tree<T extends Animal> implements Serializable, Iterable<T> {
    private List<T> list;

    public Tree() {
        list = new ArrayList<>();
    }
    public void addHuman(T human){
        if(!list.contains(human)){
            list.add(human);
            if (human.getFather() != null){
                human.getFather().addChild(human);
            }
            if (human.getMother() != null){
                human.getMother().addChild( human);
            }

        }
    }
    public String find(String name){
        StringBuffer sb = new StringBuffer();
        for (T human: list) {
            if(human.getName().equalsIgnoreCase(name)){
                sb.append(human.getInfoHuman());
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    public T getName(String name){
        for (T human:list) {
            if(human.getName().equalsIgnoreCase(name)){
                return human;
            }
        }
        return null;
    }
    public String getInfo(){
        StringBuffer sb = new StringBuffer();
        for (T human:list) {
            sb.append(human.getInfoHuman());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
    public void sortByName(){
        list.sort(new HumanFindByName<T>());
    }
    public void sortByAge(){ list.sort(new HumanFindByAge<T>()); }
}
