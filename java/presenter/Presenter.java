package presenter;

import view.View;
import model.human.Gender;
import model.human.Human;
import model.service.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

public class Presenter {
    private Service service;
    private View view;


    public Presenter(View view, Service service) {
        this.service = service;
        this.view = view;
        view.setPresenter(this);


    }

    public void addHuman(Human father, Human mother, String name, Gender gender, LocalDate birthDay, LocalDate deathDay) {
        service.addHuman( father, mother, name, gender, birthDay, deathDay);

    }
    public Human getName(String name){
        return service.getName(name);
    }
    public String find(String name) {
        return service.find(name);
    }
    public String getInfo() {
        return service.getInfo();
    }
    public void saveTree(String saveName) throws IOException {
        service.saveFile( saveName);
    }

    public void loadTree(String loadName) throws IOException, ClassNotFoundException {
        service.loadFile(loadName);
    }
    public void sortByName(){
        service.sortByName();
    }
    public void sortByAge(){
        service.sortByAge();
    }
    public void test(){
        service.test();
    }
}
