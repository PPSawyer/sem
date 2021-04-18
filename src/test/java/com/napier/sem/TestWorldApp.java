package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestWorldApp
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void mainRunTest()
    {
        App a = new App();
       // a.connect("localhost:33060");
        a.connect2();
        TheWorld emp = a.getName(55);
        a.displayWorld(emp);
        ArrayList<TheWorld> worldtables = a.CountriesReport();
        a.printWorld(worldtables);
        a.disconnect();
    }

    @Test
    void mainFailRunningTest()
    {
        App a = new App();
        TheWorld emp = a.getName(55);
        a.displayWorld(emp);
        ArrayList<TheWorld> worldtables = a.CountriesReport();
        a.printWorld(worldtables);
    }
/*
    @Test
    Connection con()
    {

    }
*/
/*
    @Test
    void connectTestNull()
    {
        app.connect (try);
    }

*/
    @Test
   void connectTest()
    {
   // app.connect("localhost:33060");
    app.connect2();
    }
/*
    @Test
    void disconnectTestNull()
    {
        app.disconnect(null);
    }
*/
    @Test
    void disconnectTest()
    {
    app.disconnect();
    }

/*
    @Test
    TheWorld getNameTestNull()
    {
        app.TheWorld(null);
    }
*/
 /*   @Test
    TheWorld getName()
    {

    }
*/
    @Test
    void displayWorldTestNull()
    {
        app.displayWorld(null);
    }

    @Test
    void displayWorld()
    {
        App a = new App();
        TheWorld emp = a.getName(55);
        a.displayWorld(emp);
    }

/*
    @Test
    ArrayList<TheWorld> CountriesReportTestNull()
    {
        app.ArrayList<TheWorld>(null);
    }
    */

    @Test
    void CountriesReport()
    {
        ArrayList<TheWorld> worldtablelist = null;

        //Statement stmt = con.createStatement();
    }



    @Test
    void printWorldStringBuilder()
    {
        StringBuilder sb = new StringBuilder();
   //     for(TheWorld emp : worldtablelist);
    }

    @Test
    void printWorldTestNull()
    {
        app.printWorld(null);
    }

    @Test
    void printWorld()
    {
        ArrayList<TheWorld> worlddetail = new ArrayList<TheWorld>();
        TheWorld emp = new TheWorld();
        emp.Code = 1;
        emp.Name = "Brazil";
        emp.District = "São Paulo";
        emp.Region = "211";
        emp.Population = 9968485;
        emp.Capital = "South America";
        worlddetail.add(emp);
        app.printWorld(worlddetail);
    }
}