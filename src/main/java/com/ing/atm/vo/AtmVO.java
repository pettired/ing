package com.ing.atm.vo;

public class AtmVO {
    private Address address;

    private String distance;

    private OpeningHours[] openingHours;

    private String functionality;

    private String type;

    public Address getAddress ()
    {
        return address;
    }

    public void setAddress (Address address)
    {
        this.address = address;
    }

    public String getDistance ()
    {
        return distance;
    }

    public void setDistance (String distance)
    {
        this.distance = distance;
    }

    public OpeningHours[] getOpeningHours ()
    {
        return openingHours;
    }

    public void setOpeningHours (OpeningHours[] openingHours)
    {
        this.openingHours = openingHours;
    }

    public String getFunctionality ()
    {
        return functionality;
    }

    public void setFunctionality (String functionality)
    {
        this.functionality = functionality;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [address = "+address+", distance = "+distance+", openingHours = "+openingHours+", functionality = "+functionality+", type = "+type+"]";
    }
}
