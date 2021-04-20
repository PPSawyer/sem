package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App
{

    /** public static void
     *
     */
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
       a.connect2();
    //    a.connect("localhost:33060");
/*
        // Connect to database
        if (args.length < 1)
        {
            a.connect("localhost:3306");
        }
        else
        {
            a.connect(args[0]);
        }
        /*
        try
        {
            a.connect2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //


         */
        //Connect to the World db
         TheWorld emp = a.getName(55);

        //Display results
        a.displayWorld(emp);

        ArrayList<TheWorld> worldtables = a.CountriesReport();

        // Print World report
        a.printWorld(worldtables);

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
 /*   public void connect(String discover)
    {
        try
        {
            // Load Database jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int reentry = 10; //Number of entries here
        for (int i = 0; i < reentry; ++i)
        {
            System.out.println("Connecting to World Database...");//Output for starting connections
            try
            {
                // Number of seconds before the database starts
                Thread.sleep(30000);

                //Running Locally Not in Docker
          //      con = DriverManager.getConnection("jdbc:mysql://localhost:33060/world?useSSL=true", "root", "example");

                // Connect to database inside docker
               // con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");

                  con = DriverManager.getConnection("jdbc:mysql://" + discover + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");

                System.out.println("Successfully connected to the World Database");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to the world database " + Integer.toString(i)); //Failed Connection
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Error, Connection error interrupted.");
            }
        }
    } //end of connect


  */
    public void connect2()
    {
        try
        {
            // Load Database jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int reentry = 10; //Number of entries here
        for (int i = 0; i < reentry; ++i)
        {
            System.out.println("Connecting to World Database...");//Output for starting connections
            try
            {
                // Number of seconds before the database starts
                Thread.sleep(30000);

                //Running Locally Not in Docker
                     con = DriverManager.getConnection("jdbc:mysql://localhost:33060/world?useSSL=true", "root", "example");

                // Connect to database inside docker
             // con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                //Wait a bit
                Thread.sleep(10000);

                System.out.println("Successfully connected to the World Database");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to the world database " + Integer.toString(i)); //Failed Connection
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Error, Connection error interrupted.");
            }
        }
    } //end of connect
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
                System.out.println("Error, lost connection to the world database");
            }
        }
    } //end of disconnect

    /**
     * This public class TheWorld
     *
     *
     */

    public TheWorld getName(int ID)
    {
        try
        {
            // Create an SQL statement here
            Statement stmt = con.createStatement();

            // Create string for SQL statement here
            String strSelect =
                    "SELECT country.Population, Continent, Region,Name, Capital "
                            + "FROM country "
                            + "WHERE Capital = " + ID;

                //    "SELECT code, name,  Continent, Region, population, capital "
                //    + "FROM country "
               //     + "Order By population desc";

            // SQL statement will execute here
            ResultSet rset = stmt.executeQuery(strSelect);

            // Return valid here
            if (rset.next())
            {
                TheWorld emp = new TheWorld();
                emp.Population = rset.getLong("Population");
                emp.Continent = rset.getString("Continent");
                emp.Region = rset.getString("Region");
                emp.Name = rset.getString("Name");
                emp.Capital = rset.getString("Capital");
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
    } //end of public class Theworld

    public void displayWorld(TheWorld emp)
    {
        if (emp != null)
        {
            System.out.println(
                    emp.Capital + " "
                            + emp.Continent + " "
                            + emp.Region + "\n"
                            + emp.Name + "\n"
                            + emp.Population + "\n"
                            + emp.Code + "\n");
        }
    }

    /**
     * Prints a list of world table columns.
     * @param worldrecords The list of columns to print.
     */

    /**
     * #SQL Query #12
     */
    public ArrayList<TheWorld> CountriesReport(){
        ArrayList<TheWorld> worldtablelist = null;
        try {
            Statement stmt = con.createStatement();


            String strSelect = " SELECT city.Name, country.Name, District,city.Population, Capital, Region, Continent "
                    + " FROM city "
                    + " INNER JOIN country ON country.Code = city.countrycode "
                    + " ORDER BY city.Population Desc limit 5; ";

            ResultSet rset = stmt.executeQuery(strSelect);
            // Return a valid response

            // Check one is returned
            while (rset.next()) {
                if(worldtablelist == null){
                    worldtablelist = new ArrayList<>();
                }
                TheWorld emp = new TheWorld();
                emp.Name = rset.getString("city.Name");
                emp.Name = rset.getString("country.Name");
                emp.District = rset.getString("District");
                emp.Population = rset.getInt("city.Population");
                emp.Capital = rset.getString("Capital");
                emp.Continent = rset.getString("Continent");
                emp.Region = rset.getString("Region");
                worldtablelist.add(emp);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Failed to get the world details");
            return worldtablelist;
        }

   StringBuilder sb = new StringBuilder();
        for(TheWorld emp : worldtablelist){

        //displayTheworld table(emp);
    sb.append(emp + "\r\n");
}

        System.out.println("" + worldtablelist.size() + " Results of the World database");
        return worldtablelist;

    }//end of countriesreport


    //Start of printWorld public
    public void printWorld(ArrayList<TheWorld> worldrecords) {

        // Check worldrecords is not null

        if (worldrecords == null) {
            System.out.println("No world list");
            return;
        }
        // Print header
        //String format to put the data into columns

        System.out.println(String.format("%-10s %-15s %-20s %-8s %-15s %-20s", "Code", "Name", "District", "Region", "Population", "Capital"));

        // Loop over all worldrecords in the list
        for (TheWorld emp : worldrecords) {
            String emp_string =
                    String.format("%-10s %-15s %-20s %-8s %-15s %-20s",
                            emp.Code, emp.Name, emp.District, emp.Capital, emp.Population, emp.Region);
            System.out.println(emp_string);
        }
    }//End of printWorld public

}