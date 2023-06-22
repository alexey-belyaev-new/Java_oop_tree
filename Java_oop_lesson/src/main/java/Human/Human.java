package Human;

import Global.Animal;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Animal {
    private String name;
    private Human father;
    private Human mother;
    private Gender gender;
    private LocalDate birthDay;
    private LocalDate deathDay;
    private List<Human> childList;
    private int age;


    public Human(Human father, Human mother, String name,Gender gender,LocalDate birthDay) {
        this.father = father;
        this.mother = mother;
        this.name = name;
        this.gender = gender;
        childList = new ArrayList<>();
        this.birthDay = birthDay;
    }
    public Human(Human father, Human mother, String name,Gender gender,LocalDate birthDay,LocalDate deathDay) {
        this.father = father;
        this.mother = mother;
        this.name = name;
        this.gender = gender;
        childList = new ArrayList<>();
        this.birthDay = birthDay;
        this.deathDay = deathDay;
    }

    public Human(String name, Gender gender, LocalDate birthDay, LocalDate deathDay) {
        this.gender = gender;
        this.name = name;
        childList = new ArrayList<>();
        this.birthDay = birthDay;
        this.deathDay = deathDay;
    }
    public Human(String name, Gender gender, LocalDate birthDay) {
        this.gender = gender;
        this.name = name;
        childList = new ArrayList<>();
        this.birthDay = birthDay;
    }

    public void addChild(Human child){
        childList.add(child);
    }
    public String getName() {
        return name;
    }


    public String getInfoHuman(){
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ");
        sb.append(name);
        sb.append(", ");
        sb.append(getStringAge());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildInfo());
        return sb.toString();
    }
    public String getMotherInfo(){
        String res = "мать: ";
        if (mother != null){
            res += mother.getName();
        }else {
            res += "неизвестен";
        }
        return res;
    }
    public String getFatherInfo(){
        String res = "отец: ";
        if (father != null){
            res += father.getName();
        }else {
            res += "неизвестен";
        }
        return res;
    }
    public String getChildInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("дети: ");
        if(childList.size() != 0){
            sb.append(childList.get(0).getName());
            for (int i = 1; i < childList.size(); i++) {
                sb.append(", ");
                sb.append(childList.get(i).getName());
            }
        }else {
            sb.append("отсутствуют");
        }
        return sb.toString();
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }
    public String getStringAge(){
        StringBuilder sb = new StringBuilder();
        sb.append("возраст: ");
        if (deathDay != null){
            age = deathDay.getYear() - birthDay.getYear();
            if (birthDay.getMonthValue() > deathDay.getMonthValue()){age--;}
        }else {
            age = LocalDate.now().getYear() - birthDay.getYear();
            if (birthDay.getMonthValue() >LocalDate.now().getMonthValue()){age--;}
        }
        sb.append(age);
        return sb.toString();
    }
    public Integer getAge(){
        return age;
    }
}

