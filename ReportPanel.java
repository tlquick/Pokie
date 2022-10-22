import model.*;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class ReportPanel extends CustomPanel
{  
    private Pokie pokie;
    
    public ReportPanel(Pokie pokie)
    {   
        this.pokie = pokie;   
        setup();
        build();
    }
    public void setup()
    {   
        setLayout(new GridLayout(1, 1));    
    }
        
    public void build()
    {   
        add(new SystemPanel());    
    }
private class SystemPanel extends JPanel implements MyObserver
{   
    private JTextField turnover = new JTextField(14);
    private JTextField winnings = new JTextField(14);
    private JTextField spins = new JTextField(4);
        
    public SystemPanel()
    {   
        pokie.attach(this);
        build();    
    }
    private void build()
    {   
        setBorder(BorderFactory.createLineBorder(Color.blue));
        addPair("Turnover", turnover);
        addPair("   Payout", winnings);
        addPair("     Spins", spins);
        addButton("Exit", new ExitListener());
        addButton("Show", new ShowListener());
        update();
    }
    private void addButton(String label, ActionListener listener)    
    {   
        JButton button = new JButton(label);
        button.addActionListener(listener);
        add(button);    
    }       
    public void addPair(String label, JTextField field)
    {   add(new JLabel(label));
        add(field); 
    }        
    public void update()
    {   
        turnover.setText(Double.toString(pokie.turnover()));
        winnings.setText(Double.toString(pokie.payouts()));
        spins.setText(Integer.toString(pokie.spins()));
    }

private class ExitListener implements ActionListener
{   public void actionPerformed(ActionEvent e)
    {  
        System.exit(0); //close application
    }
}
private class ShowListener implements ActionListener
{   public void actionPerformed(ActionEvent e)
    {  
        pokie.show(); //for debugging
    }
}
}
}