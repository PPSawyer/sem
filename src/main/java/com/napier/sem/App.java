package com.napier.sem;

import java.sql.*;

public class App
{
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        //Get Employee
         TheWorld emp = a.getName(55);

        //Display results
        a.displayWorld(emp);

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);

                //Running Locally Not in Docker
                con = DriverManager.getConnection("jdbc:mysql://localhost:33060/world?useSSL=true", "root", "example");

                // Connect to database inside docker
                //con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");

                //con = DriverManager.getConnection("", "root", "example");

                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public TheWorld getName(int ID)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Population, Continent, Region,Name "
                            + "FROM country "
                            + "WHERE Capital = " + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                TheWorld emp = new TheWorld();
                emp.Population = rset.getLong("Population");
                emp.Continent = rset.getString("Continent");
                emp.Region = rset.getString("Region");
                emp.Name = rset.getString("Name");
              //  emp.District = rset.getString("District");
               // emp.Name = rset.getString("Name");
                return emp;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the world details");
            return null;
        }
    }

    public void displayWorld(TheWorld emp)
    {
        if (emp != null)
        {
            System.out.println(
                    emp.Capital + " "
                            + emp.Continent + " "
                            + emp.Region + "\n"
                            + emp.Name + "\n");
                           // + "Salary:" + emp.salary + "\n"
                           // + emp.dept_name + "\n"
                           // + "Manager: " + emp.manager + "\n");
        }
    }
}