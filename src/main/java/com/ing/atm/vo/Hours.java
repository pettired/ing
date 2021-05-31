package com.ing.atm.vo;


public class Hours
{
    private String hourFrom;

    private String hourTo;

    public String getHourFrom ()
    {
        return hourFrom;
    }

    public void setHourFrom (String hourFrom)
    {
        this.hourFrom = hourFrom;
    }

    public String getHourTo ()
    {
        return hourTo;
    }

    public void setHourTo (String hourTo)
    {
        this.hourTo = hourTo;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [hourFrom = "+hourFrom+", hourTo = "+hourTo+"]";
    }
}


