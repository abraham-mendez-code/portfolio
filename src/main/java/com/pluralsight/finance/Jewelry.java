package com.pluralsight.finance;

public class Jewelry extends Asset{

    // class attributes
    private double karat;

    // constructor
    public Jewelry(String name, double marketValue, double karat) {

        super(name, marketValue);

        this.karat = karat;

    }

    // override
    @Override
    public double getValue() {

        return marketValue;
    }
}
