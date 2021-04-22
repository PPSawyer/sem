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
        a.connect("localhost:33060");
       // a.connect2();
        TheWorld emp = a.getName(55);
        a.displayWorld(emp);
        ArrayList<TheWorld> worldtables = a.CountriesReport();
        ArrayList<TheWorld> queryone = a.Querynumone();
        ArrayList<TheWorld> querytwo = a.Querynumtwo();
        ArrayList<TheWorld> querythree = a.Querynumthree();
        ArrayList<TheWorld> queryfour = a.Querynumfour();
        ArrayList<TheWorld> queryfive = a.Querynumfive();
        ArrayList<TheWorld> querysix = a.Querynumsix();
        ArrayList<TheWorld> queryseven = a.Querynumseven();
        ArrayList<TheWorld> queryeight = a.Querynumeight();
        ArrayList<TheWorld> querynine = a.Querynumnine();
        ArrayList<TheWorld> queryeleven = a.Querynumeleven();
        ArrayList<TheWorld> querythirteen = a.Querynumthirteen();
        ArrayList<TheWorld> queryfourteen = a.Querynumfourteen();
        ArrayList<TheWorld> querysixteen = a.Querynumsixteen();

        a.printWorld(worldtables);
        a.printWorld1(queryone);
        a.printWorld1(querytwo);
        a.printWorld1(querythree);
        a.printWorld1(queryfour);
        a.printWorld1(queryfive);
        a.printWorld1(querysix);
        a.printWorld2(queryseven);
        a.printWorld2(queryeight);
        a.printWorld2(querynine);
        a.printWorld2(queryeleven);
        a.printWorld2(querythirteen);
        a.printWorld2(queryfourteen);
        a.printWorld2(querysixteen);

        a.disconnect();
    }

    @Test
    void mainFailRunningTest()
    {
        App a = new App();
        TheWorld emp = a.getName(55);
        a.displayWorld(emp);
        ArrayList<TheWorld> worldtables = a.CountriesReport();
        ArrayList<TheWorld> queryone = a.Querynumone();
        ArrayList<TheWorld> querytwo = a.Querynumtwo();
        ArrayList<TheWorld> querythree = a.Querynumthree();
        ArrayList<TheWorld> queryfour = a.Querynumfour();
        ArrayList<TheWorld> queryfive = a.Querynumfive();
        ArrayList<TheWorld> querysix = a.Querynumsix();
        ArrayList<TheWorld> queryseven = a.Querynumseven();
        ArrayList<TheWorld> queryeight = a.Querynumeight();
        ArrayList<TheWorld> querynine = a.Querynumnine();
        ArrayList<TheWorld> queryeleven = a.Querynumeleven();
        ArrayList<TheWorld> querythirteen = a.Querynumthirteen();
        ArrayList<TheWorld> queryfourteen = a.Querynumfourteen();
        ArrayList<TheWorld> querysixteen = a.Querynumsixteen();

        a.printWorld(worldtables);
        a.printWorld1(queryone);
        a.printWorld1(querytwo);
        a.printWorld1(querythree);
        a.printWorld1(queryfour);
        a.printWorld1(queryfive);
        a.printWorld1(querysix);
        a.printWorld2(queryseven);
        a.printWorld2(queryeight);
        a.printWorld2(querynine);
        a.printWorld2(queryeleven);
        a.printWorld2(querythirteen);
        a.printWorld2(queryfourteen);
        a.printWorld2(querysixteen);
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
    app.connect("localhost:33060");
   // app.connect2();
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
    void Querynumone()
    {
        ArrayList<TheWorld> worldtablelist = null;

        //Statement stmt = con.createStatement();
    }


    @Test
    void Querynumtwo()
    {
        ArrayList<TheWorld> worldtablelist = null;

        //Statement stmt = con.createStatement();
    }

    @Test
    void Querynumthree()
    {
        ArrayList<TheWorld> worldtablelist = null;

        //Statement stmt = con.createStatement();
    }

    @Test
    void Querynumfour()
    {
        ArrayList<TheWorld> worldtablelist = null;

        //Statement stmt = con.createStatement();
    }

    @Test
    void Querynumfive()
    {
        ArrayList<TheWorld> worldtablelist = null;

        //Statement stmt = con.createStatement();
    }

    @Test
    void Querynumsix()
    {
        ArrayList<TheWorld> worldtablelist = null;

        //Statement stmt = con.createStatement();
    }

    @Test
    void Querynumseven()
    {
        ArrayList<TheWorld> worldtablelist = null;

        //Statement stmt = con.createStatement();
    }

    @Test
    void Querynumeight()
    {
        ArrayList<TheWorld> worldtablelist = null;

        //Statement stmt = con.createStatement();
    }

    @Test
    void Querynumnine()
    {
        ArrayList<TheWorld> worldtablelist = null;

        //Statement stmt = con.createStatement();
    }


    @Test
    void Querynumeleven()
    {
        ArrayList<TheWorld> worldtablelist = null;

        //Statement stmt = con.createStatement();
    }


    @Test
    void Querynumthirteen()
    {
        ArrayList<TheWorld> worldtablelist = null;

        //Statement stmt = con.createStatement();
    }

    @Test
    void Querynumfourteen()
    {
        ArrayList<TheWorld> worldtablelist = null;

        //Statement stmt = con.createStatement();
    }

    @Test
    void Querynumsixteen()
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
    void printWorldTestNull1()
    {
        app.printWorld1(null);
    }

    @Test
    void printWorldTestNull2()
    {
        app.printWorld2(null);
    }

    @Test
    void printWorldTestNull3()
    {
        app.printWorld2(null);
    }

    @Test
    void printWorldTestNull4()
    {
        app.printWorld2(null);
    }

    @Test
    void printWorldTestNull6()
    {
        app.printWorld2(null);
    }

    @Test
    void printWorldTestNull8()
    {
        app.printWorld2(null);
    }

    @Test
    void printWorldTestNull9()
    {
        app.printWorld2(null);
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

    @Test
    void printWorld1()
    {
        ArrayList<TheWorld> worlddetail = new ArrayList<TheWorld>();
        TheWorld emp = new TheWorld();
        emp.Name = "USA";
        emp.Name = "United States";
        emp.District = "North America";
        emp.Population = 278357000;
        worlddetail.add(emp);
        app.printWorld1(worlddetail);
    }

    @Test
    void printWorld2()
    {
        ArrayList<TheWorld> worlddetail = new ArrayList<TheWorld>();
        TheWorld emp = new TheWorld();
        emp.Name = "Karachi";
        emp.Name = "Brazil";
        emp.District = "São Paulo";
        emp.Population = 9968485;

        worlddetail.add(emp);
        app.printWorld2(worlddetail);
    }

    @Test
    void printWorld3()
    {
        ArrayList<TheWorld> worlddetail = new ArrayList<TheWorld>();
        TheWorld emp = new TheWorld();
        emp.Name = "Brazil";
        emp.Continent = "São Paulo";
        emp.District = "211";
        emp.Population = 9968485;
        worlddetail.add(emp);
        app.printWorld2(worlddetail);
    }

    @Test
    void printWorld4()
    {
        ArrayList<TheWorld> worlddetail = new ArrayList<TheWorld>();
        TheWorld emp = new TheWorld();
        emp.Name = "Brazil";
        emp.Region = "São Paulo";
        emp.District = "211";
        emp.Population = 9968485;
        worlddetail.add(emp);
        app.printWorld2(worlddetail);
    }

    @Test
    void printWorld6()
    {
        ArrayList<TheWorld> worlddetail = new ArrayList<TheWorld>();
        TheWorld emp = new TheWorld();
        emp.Name = "Brazil";
        emp.District = "São Paulo";
        emp.Population = 9968485;
        emp.Capital = "South America";
        worlddetail.add(emp);
        app.printWorld2(worlddetail);
    }

    @Test
    void printWorld8()
    {
        ArrayList<TheWorld> worlddetail = new ArrayList<TheWorld>();
        TheWorld emp = new TheWorld();
        emp.Name = "Brazil";
        emp.Continent = "São Paulo";
        emp.Region = "211";
        emp.Population = 9968485;
        emp.Capital = "South America";
        worlddetail.add(emp);
        app.printWorld2(worlddetail);
    }

    @Test
    void printWorld9()
    {
        ArrayList<TheWorld> worlddetail = new ArrayList<TheWorld>();
        TheWorld emp = new TheWorld();
        emp.Name = "Jakarta";
        emp.District = "Jakarta Raya";
        emp.Population = 9968485;
        emp.Capital = "South America";
        worlddetail.add(emp);
        app.printWorld2(worlddetail);
    }
}