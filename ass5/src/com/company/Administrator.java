package com.company;

public class Administrator extends Software_Engineer implements Creation, Management{
    protected String position = "Administrator";

    Administrator(){

    }

    Administrator(int salary, String name, String surname){
        this.salary = salary;
        this.name = name;
        this.surname = surname;
    }

    Administrator(String name, String surname){
        this.salary = 20000;
        this.name = name;
        this.surname = surname;
    }


    @Override
    public String manage() {
        return "Some managing";
    }
}
