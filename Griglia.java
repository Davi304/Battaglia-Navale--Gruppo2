import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Griglia extends JFrame implements ActionListener
{
    //La classe griglia crea la griglia di gioco con le matrici che stava facendo Andrea
    //
    JPanel panel = new JPanel();
    JPanel[][] caselle = new JPanel[11][11];
    Nave navi[] = new Nave[5];

    public Griglia()
    {
        // per fare la griglia usare GridLayout di 11x11
        //aggiungere la scacchiera a GridBagLayout e scrivere no GridBagContraints

        panel.setLayout(new GridLayout(11,11));

        for(int i=0; i<11; i++)
        {
            for(int j=0; j<11; j++)
            {
                caselle[i][j] = new JPanel();
                panel.add(caselle[i][j]);
            }
        }

        

         
    }

    public void actionPerformed(ActionEvent e) 
    {
    
        
    }


}
