import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Griglia extends JFrame implements ActionListener
{
    //La classe griglia crea la griglia di gioco con le matrici che stava facendo Andrea
    //
    JPanel panelCaselle = new JPanel(new GridLayout(11,11));
    JPanel panelNavi = new JPanel();
    JButton[][] bottoni = new JButton[11][11];
    JButton fuoco = new JButton();
    Nave navi[] = new Nave[5];

    public Griglia()
    {
        //Bottoni
        for(int i=0; i<11; i++)
        {
            for(int j=0; j<11; j++)
            {
                bottoni[i][j] = new JButton(new ImageIcon("Immagini/casella.jpg"));
                panelCaselle.add(bottoni[i][j]);
            }
        }
        for(int i=0; i<11; i++)
        {
            bottoni[0][i].setIcon(new ImageIcon("Immagini/casella-nome.jpg"));
            bottoni[i][0].setIcon(new ImageIcon("Immagini/casella-nome.jpg"));
        }
        

        fuoco.setText("Fuoco");
        panelNavi.add(fuoco);

        //Frame
        add(panelCaselle, BorderLayout.CENTER);
        add(panelNavi, BorderLayout.SOUTH);
        setTitle("Battaglia navale");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {
    
        
    }


}
