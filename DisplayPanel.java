import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DisplayPanel extends CustomPanel implements MyObserver
{
    private JButton credit = new JButton("Add Credit");
    private JButton collect = new JButton("Collect");
    private JTextField balance = new JTextField(10);
    private Pokie pokie;
    
    public DisplayPanel(Pokie pokie)
    {   
        this.pokie = pokie;
        pokie.attach(this);
        pokie.player().attach(this);
        setup();
        build();
    }
        
    private void setup()
    {   
        setBorder(BorderFactory.createLineBorder(Color.blue));
        collect.addActionListener(new CollectListener());   
        credit.addActionListener(new CreditListener());
    }

    private void build()
    {   

        addPair("Player Balance", balance);
        add(credit);
        add(collect);
        add(confirm);
        update();
    }
    public void update()
    {   
        Player player = pokie.player();
        balance.setText("" + player.getBalance());

    }
    public void sayCollected()
    {   
        Player player = pokie.player();
        double amount = player.getBalance();
        int games = player.getGames();
        confirm.setText("Collect $" + Double.toString(amount) + " " + Integer.toString(games) + " games played");  
    }   

private class CreditListener implements ActionListener
{   
    public CreditListener()
    {   
    }  
    public void actionPerformed(ActionEvent e)
    {   
        confirm.setText("");
        CreditWindow creditWindow = new CreditWindow(pokie);
    }
}
private class CollectListener implements ActionListener
{   
    public void actionPerformed(ActionEvent e)
    {   
        sayCollected();
        pokie.collect();
        update();
    }
}
}