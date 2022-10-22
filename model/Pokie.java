package model;

/**
 * class Pokie 
 */

public class Pokie extends Updater
{
    private final int FREE_GAMES = 3;
    private final int MAX_BET_LINES = 3;
    private int spins = 0;
    private double turnover = 0.0;
    private double payouts = 0.0;
    private Player player;
    private Lines lines;
    private int betLines;

    public Pokie()
    {
       lines = new Lines(MAX_BET_LINES);
       player = new Player(0);
    }
    public void credit(double amount)
    {
        player.addCredit(amount);
         updateViews();
    }
    public void bet(int amount)
    {
        player.setBet(amount);
        updateViews();
    }
    public void betLines(int lines)
    {
        betLines = lines;
         updateViews();
    }
    public void spin()
    {
        double wager = player.getBet()*betLines;
        player.placeBet(wager);
        turnover += wager;
        spins ++;
        lines.spin();     
        updateViews();
    }
    public String getResult()
    {
        return lines.getResult();
    }
    public void payOut()
    {
        double amount = player.payout(lines.payOff(betLines));
        player.pay(amount);
        payouts +=amount;
        updateViews();
    }
    public double getPayOut()
    {
        return player.payout(lines.payOff(betLines));
    }
    public void collect()
    {   
        player.collect();
    }  
    public Player player()
    {
        return player;
    }
    public Lines lines()
    {
        return lines;
    }
    public int getBetLines()
    {
        return betLines;
    }
    public int spins()
    {
        return spins;
    }
    public double turnover()
    {
        return turnover;
    }
    public double payouts()
    {
        return payouts;
    }
    public void show()
    {
        System.out.println(toString());
    }
    public String toString()
    {   
        String s = "Pokie Bandit:";
        s += " payouts = $" + payouts;
        s += " turnover = $" + turnover;
        s += " spins = " + spins;
        s += "\n" + player.toString();
        return s;   
    }

}
