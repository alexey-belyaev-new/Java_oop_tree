package Presenter;

import Human.*;
import Service.Service;
import View.View;

import java.time.LocalDate;

public class Presenter {
    private Service service;
    private View view;


    public Presenter(View view, Service service) {
        this.service = service;
        this.view = view;
        view.setPresenter(this);
    }

    public void addHuman(Human father, Human mother, String name, Gender gender, LocalDate birthDay, LocalDate deathDay) {
        service.addHuman(father, mother, name, gender, birthDay, deathDay);
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
}
