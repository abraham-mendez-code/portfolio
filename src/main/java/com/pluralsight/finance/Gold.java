package com.pluralsight.finance;

public class Gold extends Asset{

    // class attributes
    private double weight;

    // constructor
    public Gold(String name, double value, double weight) {

        super(name, value);

        this.weight = weight;
    }

    // override
    @Override
    public double getValue() {

        return 0;
    }

}
