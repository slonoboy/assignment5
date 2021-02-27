package com.company;

public class Administrator extends Software_Engineer implements Interface{


    Administrator(){

    }

    Administrator(int salary, String name, String surname){
        this.salary = salary;
        this.name = name;
        this.surname = surname;
        position = "Administrator";
    }

    Administrator(String name, String surname){
        this.salary = 20000;
        this.name = name;
        this.surname = surname;
        position = "Administrator";
    }


    @Override
    public String SomeAction() {
        return "Some managing";
    }
}
