import model.*;

import java.awt.*;
import javax.swing.*;

public class StoreWindow extends JFrame
{
    public StoreWindow(Pokie pokie)
    {   setup();
        build(pokie);
        setVisible(true);   
    }
    private void setup()
    {   setSize(280, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);    
    } 
    private void build(Pokie pokie)
    {   
        JTabbedPane tabber = new JTabbedPane();
        tabber.add("Play", new PlayPanel(pokie));  
        tabber.add("Report", new ReportPanel(pokie));
        add(tabber); 
    }
}
