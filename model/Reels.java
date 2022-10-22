package model;

import java.util.*;

/**
 * class Reels 
 */
public class Reels extends Records
{    
    /**
     * Constructor for objects of class Reels
     */
    public Reels(int number, int lines)
    {
        super();
        for (int i = 0; i < number; i++)
        {
           records.add(new Reel(i, lines));
        }
    }
    public void spin()
    {
        for(Record reel : records)
        {
            ((Reel)reel).spin();
        }
    }
    public String getResult(int line)
    {
        String result = "";
        for(Record reel : records)
        {
            result += ((Reel)reel).getResult(line);
        }
        return result;
    }
}
