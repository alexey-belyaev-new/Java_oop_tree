package View;

import Human.Gender;
import Human.Human;
import Presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUi implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean flag;
    private MainMenu mainMenu;

    public ConsoleUi() {
        scanner = new Scanner(System.in);
        mainMenu = new MainMenu(this);
        flag = true;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }


    @Override
    public void start() {
        System.out.println("Приветствие");
        while (flag) {
            System.out.println(mainMenu.print());
            execute();
        }
    }

    private void execute() {
        String num = scanner.nextLine();
        if (checkNum(num)) {
            int numCommand = Integer.parseInt(num);
            if (checkCommand(numCommand)) {
                mainMenu.execute(numCommand);
            }
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand > 0 && numCommand <= mainMenu.size()) {
            return true;
        } else {
            System.out.println("Ошибка ввода");
            return false;
        }
    }

    private boolean checkNum(String num) {
        if (!num.matches("[0-9]+")) {
            System.out.println("Ошибка ввода");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void addHuman() {
        Human father = setFather();
        Human mother = setMother();
        String name = setName();
        Gender gender = setGender();
        LocalDate birthday = setDay();
        LocalDate deathday = setDay();

        presenter.addHuman(father, mother, name, gender, birthday, deathday);

    }

    private LocalDate setDay() {
        System.out.println("Введите дату рождения(yyyy,MM,dd): ");
        String yearBirthday = scanner.nextLine();
        String monBirthday = scanner.nextLine();
        String dayBirthday = scanner.nextLine();
        if (checkNum(yearBirthday) || checkNum(monBirthday) || checkNum(dayBirthday)) {
            return LocalDate.of(Integer.parseInt(yearBirthday), Integer.parseInt(monBirthday), Integer.parseInt(dayBirthday));
        }
        return LocalDate.of(0, 0, 0);
    }

    private Gender setGender() {
        System.out.println("Введите пол(м/ж): ");
        String gender = scanner.nextLine();
        return checkGender(gender);
    }

    private String setName() {
        System.out.println("Введите имя: ");
        return scanner.nextLine();
    }

    private Human setMother() {
        System.out.println("Введите имя матери: ");
        String nameMother = scanner.nextLine();
        return presenter.getName(nameMother);
    }

    private Human setFather() {
        System.out.println("Введите имя отца: ");
        String nameFather = scanner.nextLine();
        return presenter.getName(nameFather);
    }


    @Override
    public void findHuman() {
        System.out.println("Введите имя для поиска: ");
        String nameFind = scanner.nextLine();
        System.out.println(presenter.find(nameFind));
    }

    @Override
    public void getInfoTree() {
        presenter.getInfo();
    }

    @Override
    public void finish() {
        System.out.println("Работа закончена.");
        flag = false;
    }

    private boolean checkName(String name) {
        if (name.matches("[а-яА-я]+")) {
            return true;
        }
        return false;
    }

    private Gender checkGender(String gender) {
        Gender gen = Gender.empty;
        if (gender.equalsIgnoreCase("м")) {
            return gen = Gender.male;
        } else if (gender.equalsIgnoreCase("ж")) {
            return gen = Gender.female;
        }
        return gen;
    }
}
