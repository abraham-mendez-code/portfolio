package com.pluralsight.finance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Portfolio implements Valuable{

    // class attributes
    String name;
    String owner;
    List<Valuable> assets;

    // constructor
    public Portfolio (String name, String owner) {

        this.name = name;
        this.owner = owner;
        assets = new ArrayList<>();

    }

    // this method adds an asset to the portfolio
    public void add (Valuable asset) {

        assets.add(asset);

    }

    // getter methods

    // this method returns all assets
    public List<Valuable> getAssets() {
        return assets;
    }

    // derived getter methods

    // this method gets the total value of the portfolio
    public double getValue() {

        double totalValue = 0;

        for (Valuable asset: assets) {

            totalValue += asset.getValue();
        }

        return totalValue;
    }

    // this method returns the most valuable asset
    public Valuable getMostValuable() {

       return Collections.max(assets, Comparator.comparing(Valuable::getValue));

    }

    // this method returns the least valuable asset
    public Valuable getLeastValuable() {

        return Collections.min(assets, Comparator.comparing(Valuable::getValue));

    }


}
