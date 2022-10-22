import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CreditWindow extends JFrame implements MyObserver
{   
    private Pokie pokie;
    private JTextField balance = new JTextField(10);
    private JButton button = new JButton("Add");
    private JLabel confirm = new JLabel("");
    private JPanel panel = new JPanel();
    public CreditWindow(Pokie pokie)
    {  
        this.pokie = pokie;
        pokie.attach(this);
        setup();
        build(pokie);
        setVisible(true);   
    }
    private void setup()
    {   
        setSize(200, 200);
        setDefaultCloseOperation(HIDE_ON_CLOSE);    
    }     
    private void build(Pokie pokie)
    {   
         panel.add(new JLabel("Enter player credit"));
         panel.add(balance);
         panel.add(button);
         button.addActionListener(new AddCreditListener(pokie));
         panel.add(confirm);
         add(panel);
    }

    public String credit()
    {   
        return balance.getText();  
    }
    public void sayNoCredit()
    {   
        confirm.setForeground(Color.red);
        confirm.setText("No amount entered");  
    }
    public void update()
    {   
        confirm.setForeground(Color.blue);
        confirm.setText("Balance updated");
    }
    public class AddCreditListener implements ActionListener
    {   
       private Pokie pokie;
        public AddCreditListener(Pokie pokie)
        {   
          this.pokie = pokie;
        }
        public void actionPerformed(ActionEvent e)
        {   
            String amount = credit();
            if (amount.length() == 0)
            {
                sayNoCredit();
            }    
            else
            {
                pokie.player().addCredit(Double.parseDouble(amount));
                update();
            }
        }
    }
}
