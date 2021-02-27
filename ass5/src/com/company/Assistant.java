package com.company;

public class Assistant extends Employee implements Interface {

    Assistant(){

    }

    Assistant(int salary, String name, String surname){
        this.salary = salary;
        this.name = name;
        this.surname = surname;
        position = "Assistant";
    }

    Assistant(String name, String surname){
        this.salary = 8000;
        this.name = name;
        this.surname = surname;
        position = "Assistant";
    }


    @Override
    public String SomeAction() {
       return "Some assist";
    }
}
