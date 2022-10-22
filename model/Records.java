package model;

import java.util.*; 
public class Records extends Updater
{
    protected LinkedList<Record> records = new LinkedList<Record>();
    protected String result = "";
    /**
     * Constructor for objects of class Records
     */
    public Records()
    {  
    }
    public void spin()
    {
        resetSpin();
    }
    public String getResult()
    {
        for (Record record : records)
        {
            result += record.toString();
        } 
        return result;
    }
    protected void resetSpin()
    {
        result = "";
    }
    public int size()
    {
        return records.size();
    }
    public String toString()
    {
        return result;
    }
}
