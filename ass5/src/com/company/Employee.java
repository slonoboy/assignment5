package com.company;

public class Employee {
    protected int salary;
    protected String name;
    protected String surname;
    protected String position;

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

    public String getPosition(){
        return position;
    }
}
