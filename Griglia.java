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
    boolean[][] griglia = new boolean[10][10];

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
        for(int i=0; i<10; i++)
        {
            for(int j=0; j<10; j++)
            {
                griglia[i][j] = false; //setta tutta la griglia su false perchè non ci sono ancora navi
            }
        }

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

            }while(controllaPosizione(posizioneX, posizioneY, orizontale, grandezza) == false);

            if(orizontale == true)
            {
                for(int j=0; i<grandezza; i++)
                {
                    griglia[posizioneX[j]][posizioneY[0]] = true; //inserisce nella griglia le navi
                }
            }
            else
            {
                for(int j=0; i<grandezza; i++)
                {
                    griglia[posizioneX[0]][posizioneY[j]] = true; //inserisce nella griglia le navi
                }
            }
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

    public boolean controllaPosizione(int[] posizioneX, int[] posizioneY, boolean orizontale, int grandezza) //ritorna true se la posizione della nave è libera
    {
        boolean controllaPosizione = true; 

        for(int i=0; i<grandezza; i++)
        {
            if(orizontale == true) //la nave è orizzontale
            {
                if(griglia[posizioneX[i]][posizioneY[0]] == true) //se è true vuol dire che c'è gia un'altra nave
                {
                    controllaPosizione = false; //lo mette a false per dire che lo spazio è gia occupato
                }
            }

            else //la nave è verticale
            {
                if(griglia[posizioneX[0]][posizioneY[i]] == true) //se è true vuol dire che c'è gia un'altra nave
                {
                    controllaPosizione = false; //lo mette a false per dire che lo spazio è gia occupato
                }
            }
        }

        return controllaPosizione;
    }

    public void actionPerformed(ActionEvent e) 
    {
       for(int i=0; i<11; i++){
            for(int j=0; j<11; j++){
                bottoni[i][j].setBackground(Color.ORANGE);
            }
       }
        
    }


}
