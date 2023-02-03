import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Griglia extends JFrame implements ActionListener
{
    //La classe griglia crea la griglia di gioco con le matrici che stava facendo Andrea
    //
    JPanel panelCaselle = new JPanel(new GridLayout(11,11));
    JPanel panelNavi = new JPanel();
    JButton[][] bottoni = new JButton[11][11];
    JButton fuoco = new JButton();
    Nave navi[] = new Nave[5];
    Random rand = new Random();
    int grandezza, posizioneX[] = new int[5], posizioneY[] = new int[5];
    boolean orizontale;

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


        //Navi
        for(int i=0; i<5; i++)
        {
            do
            {
                grandezza = i+1; //sceglie la grandezza

                orizontale = rand.nextBoolean(); //decide se è orizzontale o verticale

                if(orizontale == true) //orizzontale
                {
                    posizioneX[0] = rand.nextInt(10);
                
                    if(posizioneX[0] < 5)
                    {
                        for(int j=1; j<grandezza; j++)
                        {
                            posizioneX[j] = posizioneX[j-1]++;
                        }
                    }
                    else
                    {
                        for(int j=1; j<grandezza; j++)
                        {
                            posizioneX[j] = posizioneX[j-1]--;
                        }
                    }

                    posizioneY[0] = rand.nextInt(10);
                }
                

                else    //verticale
                {
                    posizioneY[0] = rand.nextInt(10);
                
                    if(posizioneY[0] < 5)
                    {
                        for(int j=1; j<grandezza; j++)
                        {
                            posizioneY[j] = posizioneY[j-1]++;
                        }
                    }
                    else
                    {
                        for(int j=1; j<grandezza; j++)
                        {
                            posizioneY[j] = posizioneY[j-1]--;
                        }
                    }

                    posizioneX[0] = rand.nextInt(10);
                }

            }while(controllaPosizione(navi[i]) == false);

            navi[i] = new Nave(posizioneX, posizioneY, grandezza, orizontale);
        }

        //Frame
        add(panelCaselle, BorderLayout.CENTER);
        add(panelNavi, BorderLayout.SOUTH);
        setTitle("Battaglia navale");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    public boolean controllaPosizione(Nave nave)
    {

    }

    public void actionPerformed(ActionEvent e) 
    {
    
        
    }


}
