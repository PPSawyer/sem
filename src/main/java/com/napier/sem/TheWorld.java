package com.napier.sem;
/**
 * This class connects the columns in the world database with Strings and Ints
 */
public class TheWorld {
    /**
     * Country code
     */
    public String Code;

    /**
     * country name
     */
    public String Name;

    /**
     * Country continent
     */
    public String Continent;

    /**
     * Country Region
     */
    public String Region;

    /**
     * Country Population
     */
    public long Population;

    /**
     * Country Capital
     */
    public int Capital;

    /**
     * Country Head of State
     */
    public String HeadOfState;

    /**
     * Country Government Form
     */
    public String GovernmentForm;

    /**
     * Country Code2
     */
    public int Code2;

    /**
     * Country GNP
     */
    public int GNP;

    /**
     * Country GNPOld
     */
    public int GNPOld;

    /**
     * Country LifeExpectancy
     */
    public int LifeExpectancy;

    /**
     * Country Surface Area
     */
    public int SurfaceArea;

    /**
     * Country IndepYear
     */
    public int IndepYear;

    /**
     * City ID
     */
    public int ID;

    /**
     * City CountryCode
     */
    public String CountryCode;

    /**
     * City District
     */
    public String District;

    @Override
    public String toString() {
        return "" + Code + ", " + Name + ", " + Continent + ", " + Region + ", " + Population + ", " + Capital;


    }
}

