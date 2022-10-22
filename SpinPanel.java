import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SpinPanel extends CustomPanel implements MyObserver
{
    private JButton spin = new JButton("Spin");
    private JRadioButton oneLineButton = new JRadioButton("1 line", true);
    private JRadioButton twoLineButton = new JRadioButton("2 lines");
    private JRadioButton threeLineButton = new JRadioButton("3 lines");
    private ButtonGroup lines = new ButtonGroup();
    private JRadioButton oneCreditButton = new JRadioButton("1 credit", true);
    private JRadioButton fiveCreditButton = new JRadioButton("5 Credits");
    private JRadioButton tenCreditButton = new JRadioButton("10 credits");
    private ButtonGroup credits = new ButtonGroup();
    private LineListener lineListener = new LineListener();    
    private CreditListener creditListener = new CreditListener();
    private Pokie pokie;
    
    public SpinPanel(Pokie pokie, ActionListener listener)
    {   
        this.pokie = pokie;
        pokie.attach(this);
        pokie.player().attach(this);
        setup(listener);
        build();
    }
        
    private void setup(ActionListener listener)
    {   
        setBorder(BorderFactory.createLineBorder(Color.blue));
        spin.addActionListener(listener);   
    }

    private void build()
    {   
        addRadio(oneLineButton, lines, lineListener);
        addRadio(twoLineButton, lines, lineListener);
        addRadio(threeLineButton, lines, lineListener);
        addRadio(oneCreditButton, credits, creditListener);
        addRadio(fiveCreditButton, credits, creditListener);
        addRadio(tenCreditButton, credits, creditListener);
        add(spin);
        add(confirm);
        pokie.betLines(1);
        pokie.bet(1);
        update();
    }
    private void addRadio(JRadioButton button, ButtonGroup group, ActionListener listener)
    {   
        group.add(button);
        add(button);
        button.addActionListener(listener);   
    }
    public void update()
    {           
        confirm.setText("");
    }
    private class LineListener implements ActionListener
    {   
        public void actionPerformed(ActionEvent e)
        {   
            int lines = 0;
            if (oneLineButton.isSelected())
                lines = 1;
            else if (twoLineButton.isSelected())
                lines = 2;
            else //3 lines selected
                lines = 3;
            pokie.betLines(lines);
        }
    }
    private class  CreditListener implements ActionListener
    {   
        public void actionPerformed(ActionEvent e)
        {   
            int credits = 0;
            if (oneCreditButton.isSelected())
                credits = 1;
            else if (fiveCreditButton.isSelected())
                credits = 5;
            else //10 credits per line selected
                credits = 10;
            pokie.bet(credits);
        }
    }

}