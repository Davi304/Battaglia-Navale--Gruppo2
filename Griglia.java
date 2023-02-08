import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Griglia extends JFrame implements ActionListener
{
    //La classe griglia crea la griglia di gioco con le matrici che stava facendo Andrea
    
    JPanel panelCaselle = new JPanel(new GridLayout(11,11));
    JPanel panelNavi = new JPanel();
    Bottoni[][] bottone = new Bottoni[11][11];
    JButton fuoco = new JButton();
    Nave navi[] = new Nave[5];
    Random rand = new Random();
    int grandezza, posizioneX[] = new int[5], posizioneY[] = new int[5];
    boolean orizontale;
    boolean[][] griglia = new boolean[10][10];

    public Griglia()
    {
        //Bottoni
        for(int i=1; i<11; i++)
        {
            for(int j=1; j<11; j++)
            {
                bottone[i][j] = new Bottoni((i-1), (j-1), new ImageIcon("Immagini/casella.jpg"));
            }
        }

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

        for(int i=1; i<11; i++)
        {
            bottone[i][0] = new Bottoni("" + i);
        }

        for(int i=0; i<11; i++)
        {
            for(int j=0; j<11; j++)
            {
                panelCaselle.add(bottone[i][j]);
            }
        }

        for(int i=1; i<11;i++)
        {
            for(int j=1; j<11;j++)
            {
                bottone[i][j].addActionListener(this);
            }
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
                            posizioneX[j] = posizioneX[j-1] + 1;
                        }
                    }
                    else
                    {
                        for(int j=1; j<grandezza; j++)
                        {
                            posizioneX[j] = posizioneX[j-1] - 1;
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
                            posizioneY[j] = posizioneY[j-1] + 1;
                        }
                    }
                    else
                    {
                        for(int j=1; j<grandezza; j++)
                        {
                            posizioneY[j] = posizioneY[j-1] - 1;
                        }
                    }

                    posizioneX[0] = rand.nextInt(10);
                }

            }while(controllaPosizione(posizioneX, posizioneY, orizontale, grandezza) == false);

            if(orizontale == true)
            {
                for(int j=0; j<grandezza; j++)
                {
                    griglia[posizioneX[j]][posizioneY[0]] = true; //inserisce nella griglia le navi
                }
            }
            else
            {
                for(int j=0; j<grandezza; j++)
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
        setSize(600, 600);
        setVisible(true);
        setLocationRelativeTo(null);
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
       
    }
}