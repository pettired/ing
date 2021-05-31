package com.ing.atm.vo;

public class Address
{
    private String housenumber;

    private String city;

    private GeoLocation geoLocation;

    private String street;

    private String postalcode;

    public String getHousenumber ()
    {
        return housenumber;
    }

    public void setHousenumber (String housenumber)
    {
        this.housenumber = housenumber;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    public GeoLocation getGeoLocation ()
    {
        return geoLocation;
    }

    public void setGeoLocation (GeoLocation geoLocation)
    {
        this.geoLocation = geoLocation;
    }

    public String getStreet ()
    {
        return street;
    }

    public void setStreet (String street)
    {
        this.street = street;
    }

    public String getPostalcode ()
    {
        return postalcode;
    }

    public void setPostalcode (String postalcode)
    {
        this.postalcode = postalcode;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [housenumber = "+housenumber+", city = "+city+", geoLocation = "+geoLocation+", street = "+street+", postalcode = "+postalcode+"]";
    }
}