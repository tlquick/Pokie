package model;

import java.util.*;
/**
 * class Lines 
 */
public class Lines extends Records
{
    private final int NUMBER_OF_REELS = 3;
    private Reels reels;
    /**
     * Constructor for objects of class Reels
     */
    public Lines(int number)
    {
        super();
        for (int i = 0; i < number; i++)
        {
           records.add(new Line(i));
        }
        reels = new Reels(NUMBER_OF_REELS, number);
    }
    public void spin()
    {
        resetSpin();
        reels.spin();
        for (Record line : records)
        {
          ((Line)line).spin(reels);
           result += line.toString() + "\n";
        }     
    }
    public String getResult(int number)
    {    
        return ((Line)records.get(number)).toString();
    }
    public String getResult()
    {
        return result;
    }
    public int payOff(int betLines)
    {
        int payoff = 0;
        for (Record line : records)
        {
            if(((Line)line).getNumber() < betLines)
                payoff += ((Line)line).payOff();
        }
        return payoff;
    }
    public boolean isFreeGames(int betLines)
    {
        for (Record line : records)
        {
            if(((Line)line).getNumber() < betLines)
            {
                if(((Line)line).isFreeGame())
                    return true;
            }
        }
        return false;
    }
}
