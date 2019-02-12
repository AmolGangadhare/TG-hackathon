package com.techgigandroidhackathon.VOs;

/**
 * Created by Amol G on 23-11-2017.
 */

public class RegionalBlocsVO
{
    private String[] otherAcronyms;

    private String acronym;

    private String name;

    private String[] otherNames;

    public String[] getOtherAcronyms ()
    {
        return otherAcronyms;
    }

    public void setOtherAcronyms (String[] otherAcronyms)
    {
        this.otherAcronyms = otherAcronyms;
    }

    public String getAcronym ()
    {
        return acronym;
    }

    public void setAcronym (String acronym)
    {
        this.acronym = acronym;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String[] getOtherNames ()
    {
        return otherNames;
    }

    public void setOtherNames (String[] otherNames)
    {
        this.otherNames = otherNames;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [otherAcronyms = "+otherAcronyms+", acronym = "+acronym+", name = "+name+", otherNames = "+otherNames+"]";
    }
}