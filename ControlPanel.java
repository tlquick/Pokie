
import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ControlPanel extends CustomPanel
{
    private DisplayPanel displayPanel;
    private SpinPanel spinPanel;
    private Pokie pokie;
    public ControlPanel(Pokie pokie, ActionListener listener)
    {   
       
        this.pokie = pokie;
         setup();
        build(pokie, listener);   
    }
        
    public void setup()
    {   
        setLayout(new GridLayout(2, 1)); 
        displayPanel = new DisplayPanel(pokie);
        
    }
        
    public void build(Pokie pokie, ActionListener listener)
    { 
        add(displayPanel);
        spinPanel = new SpinPanel(pokie, listener);
        add(spinPanel);
    }
    
    
}
