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