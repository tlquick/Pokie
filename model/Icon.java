package model;

public class Icon
{
    private int number;
    private String name;
    /**
     * Constructor for objects of class Icon
     */
    public Icon(int number, String name)
    {
        // initialise instance variables
        this.number = number;
        this.name = name;
    }
    public int getNumber()
    {
        return number;
    }
    public String getName()
    {
        return name;
    }
}
