package presenter;

import view.View;
import model.human.Gender;
import model.human.Human;
import model.service.Service;

import java.time.LocalDate;
import java.time.Month;

public class Presenter {
    private Service service;
    private View view;


    public Presenter(View view, Service service) {
        this.service = service;
        this.view = view;
        view.setPresenter(this);
        service.addHuman("Владимир", Gender.male, LocalDate.of(1990, Month.OCTOBER, 12), LocalDate.of(2060, Month.FEBRUARY,20));
        service.addHuman("Ольга",Gender.female, LocalDate.of(1988, Month.AUGUST, 25));
        service.addHuman(service.getName("Владимир"), service.getName("Ольга"), "Стас",Gender.male, LocalDate.of(2000, Month.APRIL,15));
        service.addHuman(service.getName("Владимир"), service.getName("Ольга"), "Екатерина",Gender.female, LocalDate.of(2003,Month.DECEMBER,20));
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
}
