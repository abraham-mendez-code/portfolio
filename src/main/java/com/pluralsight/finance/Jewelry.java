package com.pluralsight.finance;

public class Jewelry extends Asset{

    // class attributes
    private double karat;

    public Jewelry(String name, double karat) {

        super(name, karat);

        this.karat = karat;

    }

    // override
    @Override
    public double getValue() {

        return 0;
    }
}
