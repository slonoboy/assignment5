package com.company;

public class Assistant implements Creation{
    protected int salary;
    protected String name;
    protected String surname;
    protected String position = "Assistant";

    Assistant(){

    }

    Assistant(int salary, String name, String surname){
        this.salary = salary;
        this.name = name;
        this.surname = surname;
    }

    Assistant(String name, String surname){
        this.salary = 8000;
        this.name = name;
        this.surname = surname;
    }


    public void setSalary(int salary){
        this.salary = salary;
    }

    public int getSalary(){
        return salary;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getSurname(){
        return surname;
    }


    @Override
    public String SomeAction() {
       return "Some assist";
    }
}
