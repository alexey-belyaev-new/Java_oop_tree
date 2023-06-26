package view;

import model.human.Gender;
import model.human.Human;
import presenter.Presenter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUi implements View {
    private final String ERROR = "Введено некорректное значение. Повторите ввод.";
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
    public void start() throws IOException, ClassNotFoundException {
        System.out.println("Приветствие");
        while (flag) {
            System.out.println(mainMenu.print());
            execute();
        }
    }

    private void execute() throws IOException, ClassNotFoundException {
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
        if (num.equalsIgnoreCase("-")) {
            return false;
        } else if (!num.matches("[0-9]+")) {
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
        LocalDate birthday = setBirthday();
        LocalDate deathday = setDeathday();

        presenter.addHuman(father, mother, name, gender, birthday, deathday);

    }


    @Override
    public void findHuman() {
        System.out.println("Введите имя для поиска: ");
        String nameFind = scanner.nextLine();
        System.out.println(presenter.find(nameFind));
    }

    @Override
    public void getInfoTree() {
        System.out.println(presenter.getInfo());
    }

    @Override
    public void saveTree() throws IOException {
        System.out.println("Введите имя файла: ");
        String saveName = scanner.nextLine();
        String saveStr = saveName + ".out";
        presenter.saveTree(saveStr);
        System.out.println("Запись сохранена.");
    }

    @Override
    public void loadTree() throws IOException, ClassNotFoundException {
        System.out.println("Введите имя файла: ");
        boolean flag = false;
        String saveName = scanner.nextLine();
        String saveStr = saveName + ".out";
        try {
            presenter.loadTree(saveStr);
        } catch (FileNotFoundException exception) {
            System.out.println("Файл не найден");
            flag = true;
        }
        if (!flag) {
            System.out.println("Запись загружена.");
        }
    }

    @Override
    public void finish() {
        System.out.println("Работа закончена.");
        flag = false;
    }

    @Override
    public void test() {
        presenter.test();
    }

    private LocalDate setBirthday() {
        System.out.println("Введите дату рождения(yyyy,MM,dd): ");
        System.out.println("Введите год(yyyy): ");
        String yearBirthday = scanner.nextLine();
        System.out.println("Введите месяц(MM): ");
        String monBirthday = scanner.nextLine();
        System.out.println("Введите день(dd): ");
        String dayBirthday = scanner.nextLine();
        if (checkNum(yearBirthday) && checkNum(monBirthday) && checkNum(dayBirthday)) {
            return LocalDate.of(Integer.parseInt(yearBirthday), Integer.parseInt(monBirthday), Integer.parseInt(dayBirthday));
        } else {
            ErrorInput();
            return setBirthday();
        }
    }

    private LocalDate setDeathday() {
        System.out.println("Введите дату смерти: ");
        System.out.println("Введите год(yyyy): ");
        String yearBirthday = scanner.nextLine();
        System.out.println("Введите месяц(MM): ");
        String monBirthday = scanner.nextLine();
        System.out.println("Введите день(dd): ");
        String dayBirthday = scanner.nextLine();
        if (checkNum(yearBirthday) && checkNum(monBirthday) && checkNum(dayBirthday)) {
            return LocalDate.of(Integer.parseInt(yearBirthday), Integer.parseInt(monBirthday), Integer.parseInt(dayBirthday));
        } else if (yearBirthday.equalsIgnoreCase("-") && monBirthday.equalsIgnoreCase("-") && dayBirthday.equalsIgnoreCase("-")) {
            return null;
        } else {
            ErrorInput();
            return setDeathday();
        }
    }


    private Gender setGender() {
        System.out.println("Введите пол(м/ж): ");
        String gender = scanner.nextLine();
        return checkGender(gender);
    }

    private String setName() {
        System.out.println("Введите имя человека: ");
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
        checkName(nameFather);
        return presenter.getName(nameFather);
    }

    private boolean checkName(String name) {
        if (name.matches("[а-яА-я]+") && name.matches("[0-9]+")) {
            ErrorInput();
            return true;
        }
        return false;
    }

    private Gender checkGender(String gender) {
        if (gender.equalsIgnoreCase("м")) {
            return Gender.male;
        } else if (gender.equalsIgnoreCase("ж")) {
            return Gender.female;
        } else {
            ErrorInput();
            return setGender();
        }
    }

    private void ErrorInput() {
        System.out.println(ERROR);
    }

}
