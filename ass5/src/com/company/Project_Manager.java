package com.company;

public class Project_Manager extends Administrator implements Interface{


    Project_Manager(){

    }

    Project_Manager(int salary, String name, String surname){
        this.salary = salary;
        this.name = name;
        this.surname = surname;
        position = "Project manager";
    }

    Project_Manager(String name, String surname){
        this.salary = 25000;
        this.name = name;
        this.surname = surname;
        position = "Project manager";
    }


    @Override
    public String SomeAction(){
        return super.SomeAction() + " and planning";
    }
}
