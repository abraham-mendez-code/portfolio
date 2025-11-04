package com.pluralsight.finance;

public abstract class Asset implements Valuable, Comparable<Asset> {

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

    @Override
    /*
     * This is where we write the logic to sort. This method sorts
     * automatically by name if the value is the same
     */
    public int compareTo(Asset asset) {
        /*
         * Sorting by value. compareTo should return < 0 if this(keyword)
         * is supposed to be less than asset, > 0 if this is supposed to be
         * greater than object asset and 0 if they are supposed to be equal.
         */
        int value = Double.compare(this.getValue(), asset.getValue());

        // sort by name if this has the same value as asset
        return value == 0 ? this.name.compareTo(asset.name): value;
    }

}
