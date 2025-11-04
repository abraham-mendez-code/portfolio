package com.pluralsight.finance;

public abstract class Asset implements Valuable {

    // class attributes
    protected String name;
    protected double marketValue;

    // constructor
    public Asset(String name, double marketValue) {

        this.name = name;
        this.marketValue = marketValue;

    }

    @Override
    public abstract double getValue();


}
