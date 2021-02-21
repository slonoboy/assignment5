package com.company;

import java.sql.*;


public class Queries {
    private String chosen_table;

    public void setChosen_table(String name){
        chosen_table = name;
    }

    public String getChosen_table(){
        return chosen_table;
    }

    public boolean check_connection(){
        String connectionUrl = "jdbc:postgresql://localhost/Projects";
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "230801");
            stmt = con.createStatement();
            stmt.executeQuery("select 1 from " + chosen_table);
            System.out.println("Available tables:");
        }
        catch (Exception e){
            return false;
        }
        finally {
            try{
                stmt.close();
                con.close();
            }
            catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return true;
    }
    public void show_tables(){
        String connectionUrl = "jdbc:postgresql://localhost/Projects";
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "230801");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT *\n" +
                    "FROM pg_catalog.pg_tables\n" +
                    "WHERE schemaname != 'pg_catalog' AND \n" +
                    "    schemaname != 'information_schema';");
            while (rs.next())
                System.out.println("* " + rs.getString("tablename")  + " *");
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            try{
                rs.close();
                stmt.close();
                con.close();
            }
            catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }
    public void add_project(String name){
        String connectionUrl = "jdbc:postgresql://localhost/Projects";
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "230801");
            stmt = con.createStatement();
            stmt.executeQuery("create table " +name + "(id serial,\n" +
                    " firstname varchar not null,\n" +
                    " lastname varchar not null,\n" +
                    " position varchar not null,\n" +
                    " salary int not null)");
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            try{
                stmt.close();
                con.close();
            }
            catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }

    public void remove_project(String table){
        String connectionUrl = "jdbc:postgresql://localhost/Projects";
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "230801");
            stmt = con.createStatement();
            stmt.executeQuery("drop table " + table);
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            try{
                stmt.close();
                con.close();
            }
            catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }

    public void add_row(String table, String firstname, String lastname, String position, int salary){
        String connectionUrl = "jdbc:postgresql://localhost/Projects";
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "230801");
            stmt = con.createStatement();
            stmt.executeQuery("insert into "+ table +" values (default, '" + firstname + "', '" + lastname+ "', '" + position +"', '" +  salary +"')");
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            try{
                stmt.close();
                con.close();
            }
            catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }

    public void remove_row(String table, int id){
        String connectionUrl = "jdbc:postgresql://localhost/Projects";
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "230801");
            stmt = con.createStatement();
            stmt.executeQuery("delete from " + table + " where id = " + id);
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            try{
                stmt.close();
                con.close();
            }
            catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }

    public void edit_row(String table, int id, String firstname, String lastname, String position, int salary ){
        String connectionUrl = "jdbc:postgresql://localhost/Projects";
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "230801");
            stmt = con.createStatement();
            stmt.executeQuery("update "+ table +" set firstname = '"+firstname+"', lastname = '"+lastname+"', position = '"+position+"', salary = '"+salary+"' where id = "+id);
        }
        catch (Exception e){
            System.out.println("Values with id = "+id+" were edited!");
        }
        finally {
            try{
                stmt.close();
                con.close();
            }
            catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }

    }

    public void show_table(String table){
        String connectionUrl = "jdbc:postgresql://localhost/Projects";
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "230801");
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from " + table);
            System.out.println("ID  Name  Surname  Position  Salary");
            while (rs.next())
                System.out.println("|" + rs.getInt("id") + "| |" + rs.getString("firstname") + "| |" + rs.getString("lastname") + "| |" + rs.getString("position") + "| |" + rs.getString("salary") + "|");
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            try{
                rs.close();
                stmt.close();
                con.close();
            }
            catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }

    public void show_row(String table, int id){
        String connectionUrl = "jdbc:postgresql://localhost/Projects";
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "230801");
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from "+table+" where id = " + id);
            System.out.println("ID  Name  Surname  Position  Salary");
            while (rs.next())
                System.out.println("|" + rs.getInt("id") + "| |" + rs.getString("firstname") + "| |" + rs.getString("lastname") + "| |" + rs.getString("position") + "| |" + rs.getString("salary") + "|");
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            try{
                rs.close();
                stmt.close();
                con.close();
            }
            catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }
}
