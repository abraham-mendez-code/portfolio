package com.pluralsight.finance;

import javax.sound.sampled.Port;
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

    }

    public void add (Valuable asset) {

    }

    public double getValue() {

        return 0;
    }

    public Valuable getMostValuable() {

        return null;

    }

    public Valuable getleastValuable() {

        return null;

    }
}
