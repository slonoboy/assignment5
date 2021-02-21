package com.company;

public class Software_Engineer extends Assistant implements Creation{
    protected String position = "Software engineer";

    Software_Engineer(){

    }

    Software_Engineer(int salary, String name, String surname){
        this.salary = salary;
        this.name = name;
        this.surname = surname;
    }

    Software_Engineer(String name, String surname){
        salary = 15000;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String SomeAction(){
        return super.SomeAction() + " and programming";
    }


}
