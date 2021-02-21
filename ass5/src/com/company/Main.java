package com.company;

import java.util.Scanner;

public class Main {
    private static Queries query = new Queries();

    public static void main(String[] args) {
        System.out.println("Welcome to project management system!");
        table_menu();
    }

    public static void table_menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Choose a project");
        System.out.println("2. Add a project");
        System.out.println("3. Exit");
        System.out.println("Enter choice index:");
        int choice = scan.nextInt();
        switch (choice){
            case 1: choose_table();
            case 2: add_table();
            case 3: System.exit(1);
        }
    }

    public static void choose_table() {
        Scanner scan = new Scanner(System.in);
        System.out.println("* Available tables:");
        query.show_tables();
        System.out.println("-> Choose a project by its name:");
        String table_name = scan.nextLine();
        query.setChosen_table(table_name);
        if(query.check_connection()) {
            manage_menu();
        }
        else{
            System.out.println("This project do not exist!");
            choose_table();
        };
    }

    public static void add_table(){
        Scanner scan = new Scanner(System.in);
        System.out.println("-> Enter project name:");
        String name = scan.nextLine();
        query.setChosen_table(name);
        query.add_project(name);
        manage_menu();
    }

    public static void remove_table(){
        query.remove_project(query.getChosen_table());
        System.out.println("The project was successfully deleted!");
        manage_menu();
    }

    public static void manage_menu(){
        Scanner scan = new Scanner(System.in);
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
           // case 1: add();
           // case 2: output();
           // case 3: update();
          //  case 4: delete();
          //  case 5: calculate();
            case 6: remove_table();
            case 7: table_menu();
        }

    }


}
