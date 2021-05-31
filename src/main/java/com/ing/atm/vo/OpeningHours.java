package com.ing.atm.vo;


public class OpeningHours
{
    private Hours[] hours;

    private String dayOfWeek;

    public Hours[] getHours ()
    {
        return hours;
    }

    public void setHours (Hours[] hours)
    {
        this.hours = hours;
    }

    public String getDayOfWeek ()
    {
        return dayOfWeek;
    }

    public void setDayOfWeek (String dayOfWeek)
    {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [hours = "+hours+", dayOfWeek = "+dayOfWeek+"]";
    }
}
