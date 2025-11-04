package com.pluralsight.finance;

public class Gold extends FixedAsset {

    // class attributes
    private double weight;

    // constructor
    public Gold(double marketValue, double weight) {

        super("Gold", marketValue);

        this.weight = weight;
    }

    // override
    @Override
    public double getValue() {

        return marketValue;
    }

}
