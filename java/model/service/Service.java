package model.service;

import model.famalyTree.Tree;
import model.fileHandler.FileHandlerInterface;
import model.fileHandler.FileHandlerTree;
import model.human.Gender;
import model.human.Human;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private Tree<Human> activeTree;
    private final FileHandlerInterface fileHandlerTree;

    public Service(Tree<Human> activeTree, FileHandlerTree file) {
        this.activeTree = activeTree;
        this.fileHandlerTree = file;

    }

    public Service() {
        this(new Tree<>(), new FileHandlerTree());
    }

    public void addHuman(Human father, Human mother, String name, Gender gender, LocalDate birthDay, LocalDate deathDay) {
        activeTree.addHuman(new Human(father, mother, name, gender, birthDay, deathDay));

    }
    public void test(){
        activeTree.addHuman(new Human("Владимир", Gender.male, LocalDate.of(1990, Month.OCTOBER, 12), LocalDate.of(2060, Month.FEBRUARY,20)));
        activeTree.addHuman(new Human("Ольга",Gender.female, LocalDate.of(1988, Month.AUGUST, 25)));
        activeTree.addHuman(new Human(getName("Владимир"), getName("Ольга"), "Стас",Gender.male, LocalDate.of(2000, Month.APRIL,15)));
        activeTree.addHuman(new Human(getName("Владимир"), getName("Ольга"), "Екатерина",Gender.female, LocalDate.of(2003,Month.DECEMBER,20)));
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
        activeTree = (Tree<Human>) fileHandlerTree.loadFile(str);

    }

    public void sortByName() {
        activeTree.sortByName();
    }

    public void sortByAge() {
        activeTree.sortByAge();
    }
}
