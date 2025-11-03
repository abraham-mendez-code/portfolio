package com.pluralsight.finance;

public class House extends Asset{

    // class attributes
    private int yearBuilt;
    private int squareFeet;
    private int bedrooms;

    // constructor
    public House(String name, double value, int yearBuilt, int squareFeet, int bedrooms) {

        super(name, value);

        this.yearBuilt = yearBuilt;
        this.squareFeet = squareFeet;
        this.bedrooms = bedrooms;

    }

    // override
    public double getValue() {

        return 0;
    }
}
