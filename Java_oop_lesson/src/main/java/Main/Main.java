package Main;

import Human.Gender;
import Presenter.Presenter;
import Service.Service;
import View.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*Service service = new Service();
        service.addHuman("Владимир", Gender.male, LocalDate.of(1990, Month.OCTOBER, 12), LocalDate.of(2060, Month.FEBRUARY,20));
        service.addHuman("Ольга",Gender.female, LocalDate.of(1988, Month.AUGUST, 25));
        service.addHuman(service.getName("Владимир"), service.getName("Ольга"), "Стас",Gender.male, LocalDate.of(2000, Month.APRIL,15));
        service.addHuman(service.getName("Владимир"), service.getName("Ольга"), "Екатерина",Gender.female, LocalDate.of(2003,Month.DECEMBER,20));

        System.out.println(service.getInfo());
        System.out.println(service.find("Владимир"));

        service.saveFile( "tree.out");
        service.loadFile("tree.out");

        service.sortByName();
        System.out.println(service.getInfo());
        service.sortByAge();
        System.out.println(service.getInfo());*/
        View view = new ConsoleUi();
        Service service = new Service();
        new Presenter(view,service);
        view.start();
    }
}