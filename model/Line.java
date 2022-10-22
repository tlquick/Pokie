package model;

import java.util.*;
/**
 * class Line 
 */
public class Line extends Record
 {

    private String result = "JJJ";
    /**
     * Constructor for objects of class Line
     */
    public Line(int number)
    {
        super(number);
    }
    public void spin(Reels reels)
    {         
        result = reels.getResult(number);
    }
    public int payOff()
    {
        int payoff = 0;
        for (Symbol symbol: Symbol.values())
        {
            if (result.equals(symbol.getWin()))
                payoff = symbol.getPayoff();
        }
        return payoff;
    }
    public boolean isFreeGame()
    {
        return result.equals(Symbol.CHERRY.getWin());
    }
    public String toString()
    {
        return result;
    }
    
}
