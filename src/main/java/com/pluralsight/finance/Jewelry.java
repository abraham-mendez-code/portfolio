package com.pluralsight.finance;

public class Jewelry extends Asset{

    // class attributes
    private double karat;

    // constructor
    public Jewelry(String name, double value, double karat) {

        super(name, value);

        this.karat = karat;

    }

    // override
    @Override
    public double getValue() {

        return 0;
    }
}
