package com.company;

import java.util.Scanner;

public class Main {
    private static Queries query = new Queries();
    private static Employee employee = new Employee();

    public static void main(String[] args) {
        System.out.println("Welcome to project management system!");        // program stars from here
        table_menu();       // calls table_menu method
    }

    public static void table_menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Choose a project");
        System.out.println("2. Add a project");
        System.out.println("3. Exit");
        System.out.println("-> Enter choice index:");
        int choice = scan.nextInt();
        switch (choice){                // switch used to manage the menu depending on user's choice
            case 1: choose_table();     // special method calls for each choice
            case 2: add_table();
            case 3: System.exit(1);
        }
    }

    public static void choose_table() {
        Scanner scan = new Scanner(System.in);

        System.out.println("     Available projects:");
        query.show_tables();    // instance query calls method show_tables which connects to database and outputs available tables
        System.out.println("-> Choose a project by its name:");
        String table_name = scan.nextLine();
        query.setChosen_table(table_name);      // sets table name for query instance
        if(query.check_connection()) {      // checks the connection with table's name
            manage_menu();
        }
        else{
            System.out.println("This project do not exist!");

            System.out.println("Press enter to continue...");
            scan.nextLine();
            scan.nextLine();

            choose_table();
        }
    }

    public static void add_table(){
        Scanner scan = new Scanner(System.in);
        System.out.println("-> Enter project name:");
        String name = scan.nextLine();
        query.setChosen_table(name);
        query.add_project(name);

        System.out.println("Press enter to continue...");
        scan.nextLine();
        scan.nextLine();

        manage_menu();
    }

    public static void remove_table(){
        Scanner scan = new Scanner(System.in);
        query.remove_project(query.getChosen_table());

        System.out.println("Press enter to continue...");
        scan.nextLine();
        scan.nextLine();

        table_menu();
    }

    public static void manage_menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Project name -> "+ query.getChosen_table()+" <-");
        System.out.println("1. Add employee");
        System.out.println("2. Output employees");
        System.out.println("3. Update employee by id");
        System.out.println("4. Delete employee by id");
        System.out.println("5. Calculate project total cost");
        System.out.println("6. Delete this project");
        System.out.println("7. Go back");
        System.out.println("Enter choice index:");
        int choice = scan.nextInt();
        switch (choice){
            case 1: add_row();
            case 2: output();
            case 3: update();
            case 4: delete();
            case 5: calculate();
            case 6: remove_table();
            case 7: table_menu();
        }
    }

    public static void add_row(){
        Scanner scan = new Scanner(System.in);

        System.out.println("-> Choose position:");
        System.out.println("1. Project manager");
        System.out.println("2. Administrator");
        System.out.println("3. Software engineer");
        System.out.println("4. Assistant");
        int choice = scan.nextInt();

        System.out.println("-> Name of employee:");
        scan.nextLine();
        String name = scan.nextLine();

        System.out.println("-> Surname of employee:");
        String surname = scan.nextLine();

        System.out.println("-> Salary (per month)");
        int salary = scan.nextInt();

        switch (choice){
            case 1: employee = new Project_Manager(salary, name, surname);
            break;
            case 2: employee = new Administrator(salary, name, surname);
            break;
            case 3: employee = new Software_Engineer(salary, name, surname);
            break;
            case 4: employee = new Assistant(salary, name, surname);
            break;
        }

        query.add_row(query.getChosen_table(), employee.getName(), employee.getSurname(), employee.getPosition(), employee.getSalary());

        System.out.println("Press enter to continue...");
        scan.nextLine();
        scan.nextLine();

        manage_menu();
        }

    public static void output(){
        Scanner scan = new Scanner(System.in);

        System.out.println("-> Choose an option:");
        System.out.println("1. Output every row");
        System.out.println("2. Output by ID");

        int choice = scan.nextInt();
        if (choice == 1){
            query.show_table(query.getChosen_table());
        }
        else{
            System.out.println("Input row ID");
            choice = scan.nextInt();
            query.show_row(query.getChosen_table(), choice);
        }

        System.out.println("Press enter to continue...");
        scan.nextLine();
        scan.nextLine();

        manage_menu();
    }

    public static void update(){
        Scanner scan = new Scanner(System.in);

        System.out.println("-> Input an ID:");
        int id = scan.nextInt();

        System.out.println("-> Choose position:");
        System.out.println("1. Project manager");
        System.out.println("2. Administrator");
        System.out.println("3. Software engineer");
        System.out.println("4. Assistant");
        int choice = scan.nextInt();

        System.out.println("-> Name of employee:");
        scan.nextLine();
        String name = scan.nextLine();

        System.out.println("-> Surname of employee:");
        String surname = scan.nextLine();

        System.out.println("-> Salary ($ per month)");
        int salary = scan.nextInt();

        switch (choice){
            case 1: employee = new Project_Manager(salary, name, surname);
            break;
            case 2: employee = new Administrator(salary, name, surname);
            break;
            case 3: employee = new Software_Engineer(salary, name, surname);
            break;
            case 4: employee = new Assistant(salary, name, surname);
            break;
        }

        query.edit_row(query.getChosen_table(), id, employee.getName(), employee.getSurname(), employee.getPosition(), employee.getSalary());

        System.out.println("Press enter to continue...");
        scan.nextLine();
        scan.nextLine();

        manage_menu();
    }

    public static void delete(){
        Scanner scan = new Scanner(System.in);

        System.out.println("-> Input an ID:");
        int id = scan.nextInt();

        query.remove_row(query.getChosen_table(), id);
        System.out.println("Press enter to continue...");
        scan.nextLine();
        scan.nextLine();

        manage_menu();
    }

    public static void calculate(){
        Scanner scan = new Scanner(System.in);

        System.out.println("-> Input period of time (in months)");
        float month = (float) scan.nextDouble();
        System.out.println("Total cost of the project in "+month+" months = " + month * (float)query.budget(query.getChosen_table()) + "$");
        System.out.println("Press enter to continue...");
        scan.nextLine();
        scan.nextLine();
        manage_menu();
    }
    }
