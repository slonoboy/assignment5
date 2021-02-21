package com.company;

public class Project_Manager extends Administrator implements Creation, Management{
    protected String position = "Project manager";

    Project_Manager(){

    }

    Project_Manager(int salary, String name, String surname){
        this.salary = salary;
        this.name = name;
        this.surname = surname;
    }

    Project_Manager(String name, String surname){
        this.salary = 25000;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String manage(){
        return super.manage() + " and planning";
    }
}
