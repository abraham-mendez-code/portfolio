package com.pluralsight.finance;

public class House extends Asset{

    // class attributes
    private int yearBuilt;
    private int squareFeet;
    private int bedrooms;

    // constructor
    public House(String name, double marketValue, int yearBuilt, int squareFeet, int bedrooms) {

        super(name, marketValue);

        this.yearBuilt = yearBuilt;
        this.squareFeet = squareFeet;
        this.bedrooms = bedrooms;

    }

    // override
    public double getValue() {

        return marketValue;
    }
}
