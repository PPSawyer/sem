package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

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
/*
    @Test
    void mainTest()
    {
        App.main();
    }
*/
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
    app.connect();
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
/*
    @Test
    void displayWorld(TheWorld emp)
    {
        app.displayWorld();
    }
*/
 /*   @Test
    ArrayList<TheWorld> CountriesReportTestNull()
    {
        app.ArrayList<TheWorld>(null);
    }*/
/*    @Test
    ArrayList<TheWorld> CountriesReport()
    {

    }
*/
    @Test
    void printWorldStringBuilder()
    {
        StringBuilder sb = new StringBuilder();
       // for(TheWorld emp : worldtablelist);
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