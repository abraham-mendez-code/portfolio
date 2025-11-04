package com.pluralsight.finance;

import javax.sound.sampled.Port;
import java.util.ArrayList;
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

    public void add (Valuable asset) {

        assets.add(asset);

    }

    public double getValue() {

        double totalValue = 0;

        for (Valuable asset: assets) {

            totalValue += asset.getValue();
        }

        return totalValue;
    }

    public Valuable getMostValuable() {

        return null;

    }

    public Valuable getleastValuable() {

        return null;

    }
}
