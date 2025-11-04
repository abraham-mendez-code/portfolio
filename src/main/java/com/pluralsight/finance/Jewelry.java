package com.pluralsight.finance;

public class Jewelry extends FixedAsset {

    // class attributes
    private double karat;

    // constructor
    public Jewelry(double marketValue, double karat) {

        super("Jewelry", marketValue);

        this.karat = karat;

    }

    // override
    @Override
    public double getValue() {

        return marketValue;
    }
}
