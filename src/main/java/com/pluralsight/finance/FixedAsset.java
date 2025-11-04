package com.pluralsight.finance;

public abstract class FixedAsset implements Valuable {

    // class attributes
    protected String name;
    protected double marketValue;

    // constructor
    public FixedAsset(String name, double marketValue) {

        this.name = name;
        this.marketValue = marketValue;

    }

    @Override
    public abstract double getValue();

}
