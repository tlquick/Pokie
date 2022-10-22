import model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ReelPanel extends CustomPanel implements MyObserver
{   
    private JLabel result = new JLabel("Result");
    private JTextArea spin = new JTextArea("");
    private Pokie pokie;

    
    public ReelPanel(Pokie pokie)
    {   
        this.pokie = pokie;
        pokie.attach(this);
        setup();
        build();
    }
      
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setResult(g);
    } 
    private void setResult(Graphics g)
    {
        //tokenise and set all 9 images to screen
        Lines lines = pokie.lines();
        for(int i = 0; i < lines.size(); i++)//for each line
        {
            String lineResult = lines.getResult(i); //has 3 reel results - use charAt()
            for(int j = 0; j < lineResult.length(); j++)
            {
                String image = getImage("" + lineResult.charAt(j));
                setImage(i, j, image, g);
            }
        }
    }
    private String getImage(String result)//lookup symbol and find the image to show
    {
        for(Symbol symbol : Symbol.values())
        {
            if(symbol.getName().equals(result))
                return symbol.getImage();
        }
        return "";
    }
    private void setImage(int line, int reel, String image, Graphics g)
    {
        Image im = Toolkit.getDefaultToolkit().getImage(image);//computer image
        g.drawImage(im,(reel*60) + 40,(line+1)*60,65,65,this);
    }
    private void setup()
    {   
        setBorder(BorderFactory.createLineBorder(Color.blue)); 
    }

    private void build()
    {    
        add(confirm);
    }

    public void sayNoBet()
    {   
        confirm.setForeground(Color.blue);
        confirm.setText("No bet placed");  
    }   
    public void sayNoMoney()
    {   
        confirm.setForeground(Color.blue);
        confirm.setText("Not enough doe bro");  
    } 
    public void sayNothing()
    {   
        confirm.setForeground(Color.blue);
        confirm.setText("");  
    } 

    public void displayWinAmount(double amount)
    {
        confirm.setForeground(Color.blue);
        confirm.setText("Congratulations! Win $" + amount);
    }
    public void spinLine()
    {
        pokie.spin();
        repaint();
        pokie.payOut();
        double amount = pokie.getPayOut();
        if ( amount > 0)
        {
            displayWinAmount(amount);
        }
        else
        {
            sayNothing();
        }

    }
    public void update()
    {   

    }


}
