package Service;

import Human.*;
import FileHandler.*;
import Global.Tree;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private Tree<Human> activeTree;
    private List<Tree> treeList;
    private FileHandlerInterface fileHandlerTree;

    public Service(Tree<Human> activeTree, FileHandlerTree file) {
        this.activeTree = activeTree;
        this.fileHandlerTree = file;
        treeList = new ArrayList<>();

    }

    public Service() {
        this(new Tree<>(), new FileHandlerTree());
    }

    public void addTree(Tree<Human> tree) {
        treeList.add(tree);
    }

    public void addHuman(Human father, Human mother, String name, Gender gender, LocalDate birthDay) {
        activeTree.addHuman(new Human(father, mother, name, gender, birthDay));
    }

    public void addHuman(Human father, Human mother, String name, Gender gender, LocalDate birthDay, LocalDate deathDay) {
        activeTree.addHuman(new Human(father, mother, name, gender, birthDay, deathDay));
    }

    public void addHuman(String name, Gender gender, LocalDate birthDay, LocalDate deathDay) {
        activeTree.addHuman(new Human(name, gender, birthDay, deathDay));
    }

    public void addHuman(String name, Gender gender, LocalDate birthDay) {
        activeTree.addHuman(new Human(name, gender, birthDay));
    }

    public Human getName(String str) {
        return activeTree.getName(str);
    }

    public String getInfo() {
        return activeTree.getInfo();
    }

    public String find(String name) {
        return activeTree.find(name);
    }

    public void saveFile(String str) throws IOException {
        fileHandlerTree.saveFile(activeTree, str);
    }

    public void loadFile(String str) throws IOException, ClassNotFoundException {
        fileHandlerTree.loadFile(str);
    }

    public void sortByName() {
        activeTree.sortByName();
    }

    public void sortByAge() {
        activeTree.sortByAge();
    }
}
