package com.techgigandroidhackathon.VOs;

/**
 * Created by Amol G on 23-11-2017.
 */

public class CurrenciesVO
{
    private String symbol;

    private String name;

    private String code;

    public String getSymbol ()
    {
        return symbol;
    }

    public void setSymbol (String symbol)
    {
        this.symbol = symbol;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [symbol = "+symbol+", name = "+name+", code = "+code+"]";
    }
}