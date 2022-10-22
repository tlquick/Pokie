package model;

import java.util.*;
/**
 * class Reel - This class is complete
 */
public class Reel extends Record
{
    private final int REEL_SIZE = 64;
    private int betLines[];//used to store result for each line - this is the only array allowed in the assignment
    private LinkedList<Icon> icons = new LinkedList<Icon>();
    public Reel(int number, int lines)
    {
        super(number);
        betLines = new int [lines];
        build();
    }
    protected void build()
    {
        int j = 0;
        for (Symbol symbol: Symbol.values())
        {
            for (int i = 0; i < symbol.getNumber(); i ++)
            {
                icons.add(new Icon(j++, symbol.getName())); 
            }
        }
        Collections.shuffle(icons);//randomise the order of icons
    }
    public void spin()
    {
       int random = (int)(Math.random()* REEL_SIZE); 
       for(int i = 0; i < betLines.length; i++)
       {
           if(random > REEL_SIZE - 1)//need to check end of list
                random = 0;
           else
                betLines[i] = random;
           random++;
        }           
    }
    public String getResult(int line)
    {
        Icon icon = icons.get(betLines[line]);
        return icon.getName();
    }
}
