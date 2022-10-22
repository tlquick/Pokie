import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import model.*;

public class PlayPanel extends JPanel implements MyObserver
{
    private Pokie pokie;
    private ControlPanel controlPanel;
    private ReelPanel reelPanel;
    
    public PlayPanel(Pokie pokie)
    {   
        setup();
        this.pokie = pokie;
        build(pokie);   
    }
        
    public void setup()
    {   
        setLayout(new GridLayout(2, 1));   
    }
        
    public void build(Pokie pokie)
    {    
        reelPanel = new ReelPanel(pokie);
        controlPanel = new ControlPanel(pokie, new SpinListener());
        add(reelPanel);
        add(controlPanel);
    }
    public void update()
    {   
        
    }
    private class SpinListener implements ActionListener
    {   
    
    public void actionPerformed(ActionEvent e)
    {   
        
        Player player = pokie.player();
        if (player.getBet() <= 0)
        {
            reelPanel.sayNoBet();
        }
        else if(!player.canBet(pokie.getBetLines()))
        {
            reelPanel.sayNoMoney();
        }
        else
        {
            reelPanel.sayNothing();
            reelPanel.spinLine();
            Lines lines = pokie.lines();
            update();
        }
        
    }
    
}
}
