package model;


public class Record extends Updater
{
    protected int number;
    public Record(int number)
    {
        this. number = number;
    }
    public int getNumber()
    {
        return number;
    }
    public String toString()
    {
        return "" + number;
    }
}
