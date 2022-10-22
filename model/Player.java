package model;


/**
 * class Player 
 */
public class Player extends Updater 
{
    private double balance;
    private double bet = 0.0;
    private int games;

    /**
     * Constructor for objects of class Player
     */
    public Player(double balance)
    {
        this.balance = balance;
        games = 0;
    }
    public boolean noBet()
    {
        return bet == 0.0;
    }
    public boolean canBet(int lines)
    {
        return balance >= bet*lines;
    }
    public void placeBet(double betAmount)
    {
        balance -= betAmount;
        games++;
         updateViews();
    }
    public double payout(double amount)
    {
        return bet * amount;
    }
    public void pay(double amount)
    {
        balance += amount;
         updateViews();
    }
    public void collect()
    {
        System.out.println("Collect $" + balance + " " + games + " games played"); 
        balance = 0;
         updateViews();
    }
    public void addCredit(double amount)
    {
        balance += amount;
         updateViews();
    }
    public void setBet(double bet)
    {
        this.bet = bet;
    }
    public double getBet()
    {
        return bet;
    }
    public double getBalance()
    {
        return balance;
    }
    public int getGames()
    {
        return games;
    }
    public String toString()
    {
        return "Player: bet $" + bet + " balance $" + balance + " games played " + games;
    }
}
