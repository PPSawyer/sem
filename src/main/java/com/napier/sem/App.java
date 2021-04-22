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
        if (args.length < 1)
        {
            a.connect("localhost:33060");
        }
        else
        {
            a.connect(args[0]);
        }

        //Connect to the World db
         TheWorld emp = a.getName(55);

        //Display results
        a.displayWorld(emp);

        //Example Query
        ArrayList<TheWorld> worldtables = a.CountriesReport();

        //Query1
        ArrayList<TheWorld> queryone = a.Querynumone();

        //Query2
        ArrayList<TheWorld> querytwo = a.Querynumtwo();

        //Query3
        ArrayList<TheWorld> querythree = a.Querynumthree();

        //Query4
        ArrayList<TheWorld> queryfour = a.Querynumfour();

        //Query 5
        ArrayList<TheWorld> queryfive = a.Querynumfive();

        //Query6
        ArrayList<TheWorld> querysix = a.Querynumsix();

        //Query7
        ArrayList<TheWorld> queryseven = a.Querynumseven();

        //Query8
        ArrayList<TheWorld> queryeight = a.Querynumeight();

        //Query9
        ArrayList<TheWorld> querynine = a.Querynumnine();

        //Query11
        ArrayList<TheWorld> queryeleven = a.Querynumeleven();

        //Query13
        ArrayList<TheWorld> querythirteen = a.Querynumthirteen();

        //Query14
        ArrayList<TheWorld> queryfourteen = a.Querynumfourteen();

        //Query16
        ArrayList<TheWorld> querysixteen = a.Querynumsixteen();

        // Print World report
        a.printWorld(worldtables);

        //Query1 Print
        a.printWorld1(queryone);

        //Query2 Print
        a.printWorld1(querytwo);

        //Query3 Print
        a.printWorld1(querythree);

        //Query4 Print
        a.printWorld1(queryfour);

        //Query5 Print
        a.printWorld1(queryfive);

        //Query6 Print
        a.printWorld1(querysix);

        //Query7 Print
        a.printWorld2(queryseven);

        //Query8 Print
        a.printWorld2(queryeight);

        //Query9 Print
        a.printWorld2(querynine);

        //Query11 Print
        a.printWorld2(queryeleven);

        //Query13 Print
        a.printWorld2(querythirteen);

        //Query14 Print
        a.printWorld2(queryfourteen);

        //Query16 Print
        a.printWorld2(querysixteen);

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
    public void connect(String discover)
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
                Thread.sleep(10000);

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
     * #SQL Query Example
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

    /**
     * #SQL Query #1
     */
    public ArrayList<TheWorld> Querynumone(){
        ArrayList<TheWorld> worldtablelist1 = null;
        try {
            Statement stmt = con.createStatement();


            String strSelect = " SELECT code, Name, Continent, Region, Population, Capital "
                    + " FROM country "
                    + " ORDER BY Population Desc limit 5; ";

            ResultSet rset = stmt.executeQuery(strSelect);
            // Return a valid response

            // Check one is returned
            while (rset.next()) {
                if(worldtablelist1 == null){
                    worldtablelist1 = new ArrayList<>();
                }
                TheWorld emp = new TheWorld();
                emp.Code = rset.getString("Code");
                emp.Name = rset.getString("Name");
                emp.Continent = rset.getString("Continent");
                emp.Region = rset.getString("Region");
                emp.Population = rset.getInt("Population");
                emp.Capital = rset.getString("Capital");


                worldtablelist1.add(emp);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Failed to get the world details");
            return worldtablelist1;
        }


        StringBuilder sb = new StringBuilder();
        for(TheWorld emp : worldtablelist1){

            //displayTheworld table(emp);
            sb.append(emp + "\r\n");
        }

        System.out.println("" + worldtablelist1.size() + " Results of the World database");
        return worldtablelist1;

    }//end of Query1

    /**
     * #SQL Query #2
     */
    public ArrayList<TheWorld> Querynumtwo(){
        ArrayList<TheWorld> worldtablelist = null;
        try {
            Statement stmt = con.createStatement();


            String strSelect = " SELECT code, Name, Continent, Region, Population, Capital "
                    + " FROM country "
                    + "WHERE Continent = 'North America'  "
                    + " ORDER BY Population Desc limit 5; ";

            ResultSet rset = stmt.executeQuery(strSelect);
            // Return a valid response

            // Check one is returned
            while (rset.next()) {
                if(worldtablelist == null){
                    worldtablelist = new ArrayList<>();
                }
                TheWorld emp = new TheWorld();
                emp.Code = rset.getString("Code");
                emp.Name = rset.getString("Name");
                emp.Continent = rset.getString("Continent");
                emp.Region = rset.getString("Region");
                emp.Population = rset.getInt("Population");
                emp.Capital = rset.getString("Capital");


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

    }//end of Query2

    /**
     * #SQL Query #3
     */
    public ArrayList<TheWorld> Querynumthree(){
        ArrayList<TheWorld> worldtablelist = null;
        try {
            Statement stmt = con.createStatement();


            String strSelect = " SELECT code, Name, Continent, Region, Population, Capital "
                    + " FROM country "
                    + "WHERE Region = 'Southeast Asia'  "
                    + " ORDER BY Population Desc limit 5; ";

            ResultSet rset = stmt.executeQuery(strSelect);
            // Return a valid response

            // Check one is returned
            while (rset.next()) {
                if(worldtablelist == null){
                    worldtablelist = new ArrayList<>();
                }
                TheWorld emp = new TheWorld();
                emp.Code = rset.getString("Code");
                emp.Name = rset.getString("Name");
                emp.Continent = rset.getString("Continent");
                emp.Region = rset.getString("Region");
                emp.Population = rset.getInt("Population");
                emp.Capital = rset.getString("Capital");


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

    }//end of Query3


    /**
     * #SQL Query #4
     */
    public ArrayList<TheWorld> Querynumfour(){
        ArrayList<TheWorld> worldtablelist = null;
        try {
            Statement stmt = con.createStatement();


            String strSelect = " SELECT code, Name, Continent, Region, Population, Capital "
                    + " FROM country "
                    + " ORDER BY Population Desc limit 5; ";

            ResultSet rset = stmt.executeQuery(strSelect);
            // Return a valid response

            // Check one is returned
            while (rset.next()) {
                if(worldtablelist == null){
                    worldtablelist = new ArrayList<>();
                }
                TheWorld emp = new TheWorld();
                emp.Code = rset.getString("Code");
                emp.Name = rset.getString("Name");
                emp.Continent = rset.getString("Continent");
                emp.Region = rset.getString("Region");
                emp.Population = rset.getInt("Population");
                emp.Capital = rset.getString("Capital");


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

    }//end of Query4
    /**
     * #SQL Query #5
     */
    public ArrayList<TheWorld> Querynumfive(){
        ArrayList<TheWorld> worldtablelist = null;
        try {
            Statement stmt = con.createStatement();


            String strSelect = " SELECT code, Name, Continent, Region, Population, Capital "
                    + " FROM country "
                    + " WHERE Continent = 'Asia' "
                    + " ORDER BY Population Desc limit 5; ";

            ResultSet rset = stmt.executeQuery(strSelect);
            // Return a valid response

            // Check one is returned
            while (rset.next()) {
                if(worldtablelist == null){
                    worldtablelist = new ArrayList<>();
                }
                TheWorld emp = new TheWorld();
                emp.Code = rset.getString("Code");
                emp.Name = rset.getString("Name");
                emp.Continent = rset.getString("Continent");
                emp.Region = rset.getString("Region");
                emp.Population = rset.getInt("Population");
                emp.Capital = rset.getString("Capital");


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

    }//end of Query 5


    /**
     * #SQL Query #6
     */
    public ArrayList<TheWorld> Querynumsix(){
        ArrayList<TheWorld> worldtablelist = null;
        try {
            Statement stmt = con.createStatement();


            String strSelect = " SELECT code, Name, Continent, Region, Population, Capital "
                    + " FROM country "
                    + " WHERE Region = 'Eastern Asia' "
                    + " ORDER BY Population Desc limit 5; ";

            ResultSet rset = stmt.executeQuery(strSelect);
            // Return a valid response

            // Check one is returned
            while (rset.next()) {
                if(worldtablelist == null){
                    worldtablelist = new ArrayList<>();
                }
                TheWorld emp = new TheWorld();
                emp.Code = rset.getString("Code");
                emp.Name = rset.getString("Name");
                emp.Continent = rset.getString("Continent");
                emp.Region = rset.getString("Region");
                emp.Population = rset.getInt("Population");
                emp.Capital = rset.getString("Capital");


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

    }//end of Query6

    /**
     * #SQL Query #7
     */
    public ArrayList<TheWorld> Querynumseven(){
        ArrayList<TheWorld> worldtablelist = null;
        try {
            Statement stmt = con.createStatement();


            String strSelect = " SELECT city.Name, country.Name, District, city.Population "
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
                emp.Name = rset.getString("Name");
                emp.Name = rset.getString("country.Name");
                emp.District = rset.getString("District");
                emp.Population = rset.getInt("city.Population");



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

    }//end of Query7

    /**
     * #SQL Query #8
     */
    public ArrayList<TheWorld> Querynumeight(){
        ArrayList<TheWorld> worldtablelist = null;
        try {
            Statement stmt = con.createStatement();


            String strSelect = " SELECT city.Name, country.Name, District, city.Population  "
                    + " FROM city "
                    + " INNER JOIN country ON city.countrycode = country.code "
                    + "WHERE Continent = 'Asia' "
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

    }//end of Query8

    /**
     * #SQL Query #9
     */
    public ArrayList<TheWorld> Querynumnine(){
        ArrayList<TheWorld> worldtablelist = null;
        try {
            Statement stmt = con.createStatement();


            String strSelect = " SELECT city.Name, country.Name, District, city.Population  "
                    + " FROM city "
                    + " INNER JOIN country ON city.countrycode = country.code "
                    + "WHERE Region = 'Eastern Asia' "
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

    }//end of Query9

    /**
     * #SQL Query #11
     */
    public ArrayList<TheWorld> Querynumeleven(){
        ArrayList<TheWorld> worldtablelist = null;
        try {
            Statement stmt = con.createStatement();


            String strSelect = " SELECT city.Name, country.Name, District, city.Population  "
                    + " FROM city "
                    + " INNER JOIN country ON city.countrycode = country.code "
                    + "WHERE District = 'Peking' "
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

    }//end of Query11

    /**
     * #SQL Query #13
     */
    public ArrayList<TheWorld> Querynumthirteen(){
        ArrayList<TheWorld> worldtablelist = null;
        try {
            Statement stmt = con.createStatement();


            String strSelect = " SELECT city.Name, country.Name, District, city.Population "
                    + " FROM city "
                    + "INNER JOIN country ON city.countrycode = country.Code"
                    + " WHERE Continent = 'Asia' "
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
                emp.Population = rset.getInt("Population");


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

    }//end of Query 13

    /**
     * #SQL Query #14
     */
    public ArrayList<TheWorld> Querynumfourteen(){
        ArrayList<TheWorld> worldtablelist = null;
        try {
            Statement stmt = con.createStatement();


            String strSelect = " SELECT city.Name, country.Name, District, city.Population "
                    + " FROM city "
                    + "INNER JOIN country ON city.countrycode = country.Code"
                    + " WHERE Region = 'Eastern Asia' "
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
                emp.Population = rset.getInt("Population");



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

    }//end of Query 14


    /**
     * #SQL Query #16
     */
    public ArrayList<TheWorld> Querynumsixteen(){
        ArrayList<TheWorld> worldtablelist = null;
        try {
            Statement stmt = con.createStatement();


            String strSelect = " SELECT city.Name, country.Name, District, city.Population "
                    + " FROM city "
                    + "INNER JOIN country ON city.countrycode = country.Code"
                    + " WHERE District = 'Seoul' "
                    + " ORDER BY city.Population Desc limit 5; ";

            ResultSet rset = stmt.executeQuery(strSelect);
            // Return a valid response

            // Check one is returned
            while (rset.next()) {
                if(worldtablelist == null){
                    worldtablelist = new ArrayList<>();
                }
                TheWorld emp = new TheWorld();
                emp.Name = rset.getString("country.Name");
                emp.Name = rset.getString("country.Name");
                emp.District = rset.getString("District");
                emp.Population = rset.getInt("Population");



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

    }//end of Query 16


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


    //Start of printWorld public for Query1, 2, 3, 4, 5, and 6
    public void printWorld1(ArrayList<TheWorld> worldrecords) {

        // Check worldrecords is not null

        if (worldrecords == null) {
            System.out.println("No world list");
            return;
        }
        // Print header
        //String format to put the data into columns

        System.out.println(String.format("%-10s %-15s %-20s %-8s %-15s %-20s", "Code", "Name", "Continent", "Region", "Population", "Capital"));

        // Loop over all worldrecords in the list
        for (TheWorld emp : worldrecords) {
            String emp_string =
                    String.format("%-10s %-15s %-20s %-8s %-15s %-20s",
                            emp.Code, emp.Name, emp.Continent, emp.Region, emp.Population, emp.Capital);
            System.out.println(emp_string);
        }
    }//End of printWorld public Query1, 2, 3, 4, 5, and 6


    //Start of printWorld public for Query7, 8, 9, 11, 13,14,16
    public void printWorld2(ArrayList<TheWorld> worldrecords) {

        // Check worldrecords is not null

        if (worldrecords == null) {
            System.out.println("No world list");
            return;
        }
        // Print header
        //String format to put the data into columns

        System.out.println(String.format("%-10s %-15s %-20s %-8s", "Cityname", "CountryName", "District", "Population"));

        // Loop over all worldrecords in the list
        for (TheWorld emp : worldrecords) {
            String emp_string =
                    String.format("%-10s %-15s %-20s %-8s",
                            emp.Name, emp.Name, emp.District, emp.Population);
            System.out.println(emp_string);
        }
    }//End of printWorld public Query7, 8, 9, 11, 13, 14, 16


}
