import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


//non abbiamo abbastanza tempo per finirlo
public class SecondaGriglia extends JFrame implements ActionListener
{
    Bottoni[][] bottone  = new Bottoni[11][11];
    JButton[] bottoniNavi = new JButton[5];
    //JPanel totale = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
    JPanel panelBottoni = new JPanel(new GridLayout(11, 11));
    JPanel selezioneNavi = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
    Font f = new Font("Comic Sans", Font.CENTER_BASELINE,20);
    
    public SecondaGriglia()
    {
        creaBottoni();

        //Panel
        for(int i=0; i<5; i++)
        {
            bottoniNavi[i] = new JButton();
            bottoniNavi[i].setText("" + (i+1));
            bottoniNavi[i].setFont(f);
            selezioneNavi.add(bottoniNavi[i]);
        }

        //Frame
        //setLayout(new GridLayout(3,1));
        
        add(panelBottoni, BorderLayout.CENTER);
        add(selezioneNavi, BorderLayout.SOUTH);
        setTitle("Battaglia navale");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,800);
        //setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void creaBottoni() 
    {
        //caselle del mare 
        for(int i=1; i<11; i++)
        {
            for(int j=1; j<11; j++)
            {
                bottone[i][j] = new Bottoni((i-1), (j-1));
                bottone[i][j].setBackground(new Color(0, 29, 64));
                bottone[i][j].setFont(f);

                bottone[i][j].addActionListener(this);
            }
        }
        
        //caselle segna posizione delle lettere
        bottone[0][0] = new Bottoni("");
        bottone[0][1] = new Bottoni("A");
        bottone[0][2] = new Bottoni("B");
        bottone[0][3] = new Bottoni("C");
        bottone[0][4] = new Bottoni("D");
        bottone[0][5] = new Bottoni("E");
        bottone[0][6] = new Bottoni("F");
        bottone[0][7] = new Bottoni("G");
        bottone[0][8] = new Bottoni("H");
        bottone[0][9] = new Bottoni("I");
        bottone[0][10] = new Bottoni("L");

        for(int i=0; i<11; i++)
        {
            bottone[0][i].setFont(f);
            bottone[0][i].setBackground(new Color(224,90,122));
        }

        //caselle segna posizione dei numeri
        for(int i=1; i<11; i++)
        {
            bottone[i][0] = new Bottoni("" + i);
            bottone[i][0].setBackground(new Color(224,90,122));
            bottone[i][0].setFont(f);
        }

        //prima casella
        bottone[0][0].setBackground(Color.WHITE);

        //aggiunge i bottoni al panel
        for(int i=0; i<11; i++)
        {
            for(int j=0; j<11; j++)
            {
                panelBottoni.add(bottone[i][j]);
                
            }
        }
    }

    public void actionPerformed(ActionEvent e) 
    {
        
    }
}