package edu.miracosta.cs113.change;

import java.util.*;

public class Coin
{
    // instance variables - replace the example below with your own
    int numberOfPennys;
    int numberOfDimes;
    int numberOfNickles;
    int numberOfQuarters;

    /**
     * Constructor for objects of class Coin
     */
    public Coin()
    {
        numberOfPennys = 0;
        numberOfDimes = 0;
        numberOfNickles = 0;
        numberOfQuarters = 0;
    }

    public Coin(Coin coin)
    {
        this.numberOfPennys = coin.numberOfPennys;
        this.numberOfDimes = coin.numberOfDimes;
        this.numberOfNickles = coin.numberOfNickles;
        this.numberOfQuarters = coin.numberOfQuarters;
    }

    public void addPenny()
    {
        numberOfPennys = numberOfPennys +1;
    }

    public void addQuarter()
    {
        numberOfQuarters = numberOfQuarters +1;
    }

    public void addNickle()
    {
        numberOfNickles = numberOfNickles +1;
    }

    public void addDime()
    {
        numberOfDimes = numberOfDimes +1;
    }

    public String toString()
    {
        String stuff = "P D N Q\n";
        stuff += String.format(Integer.toString(numberOfPennys) +" "+  numberOfDimes+ " " +numberOfNickles + " "+ numberOfQuarters);
        return stuff;
    }

    public boolean equals(Object o)
    {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Coin))
        {
            return false;
        }

        Coin c = (Coin) o;

        return Integer.compare(numberOfPennys, c.numberOfPennys) == 0
                && Integer.compare(numberOfDimes, c.numberOfDimes) == 0
                && Integer.compare(numberOfNickles, c.numberOfNickles) == 0
                && Integer.compare(numberOfQuarters, c.numberOfQuarters) == 0;
    }
}
