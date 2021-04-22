package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");
       // app.connect2();
    }


    @Test
    void testGetWorldDetails()
    {
        TheWorld emp = app.getName(55);
        assertEquals(emp.Code, null);
        assertEquals(emp.Name, "Andorra");
        assertEquals(emp.District, null);
    }


    @Test
    void CountriesReport()
    {
        ArrayList<TheWorld> worldtablelist = null;

        //Statement stmt = con.createStatement();
    }



}