package model;

import java.util.ArrayList;
import java.util.List;

public class Pilot {
    private int id;
    private int identificationCode;
    private String name;
    private int age;
    private List<String> planeNameList = new ArrayList<>();

    public Pilot() {
    }

    public int getIdentificationCode() {
        return identificationCode;
    }

    public void setIdentificationCode(int identificationCode) {
        this.identificationCode = identificationCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getNamePlaneList() {
        return planeNameList;
    }

    public void setNamePlaneList(String planeName) {

        this.planeNameList.add(planeName);
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", planeList=" + planeNameList +
                '}';
    }
}
