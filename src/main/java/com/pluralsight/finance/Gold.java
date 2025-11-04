package com.pluralsight.finance;

public class Gold extends FixedAsset {

    // class attributes
    private double weight;

    // constructor
    public Gold(String name, double marketValue, double weight) {

        super(name, marketValue);

        this.weight = weight;
    }

    // override
    @Override
    public double getValue() {

        return marketValue;
    }

}
