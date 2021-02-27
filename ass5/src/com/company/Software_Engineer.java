package com.company;

public class Software_Engineer extends Assistant implements Interface{

    Software_Engineer(){

    }

    Software_Engineer(int salary, String name, String surname){
        this.salary = salary;
        this.name = name;
        this.surname = surname;
        position = "Software engineer";

    }

    Software_Engineer(String name, String surname){
        salary = 15000;
        this.name = name;
        this.surname = surname;
        position = "Software engineer";

    }


    @Override
    public String SomeAction(){
        return super.SomeAction() + " and programming";
    }
}
