import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Griglia_personale extends JFrame
{
    int numTurni;
    JPanel testoRisultato = new JPanel(new GridLayout(1,1));
    JPanel panelCaselle = new JPanel(new GridLayout(11,11));
    JPanel testo = new JPanel(new GridLayout(2,1));
    JLabel counter = new JLabel(), info = new JLabel(), info2 = new JLabel(), infoAffondata = new JLabel();
    Bottoni[][] bottone = new Bottoni[11][11];
    Nave navi[] = new Nave[5];
    Random rand = new Random();
    int grandezza, posizioneX[][] = new int[5][5], posizioneY[][] = new int[5][5];
    int x,y, indice;
    int contatore=0;
    int contatore2 =0;
    int numNaviAffondate=0;
    boolean orizontale;
    boolean affondata;
    boolean[][] griglia = new boolean[10][10];
    Font f = new Font("Comic Sans", Font.CENTER_BASELINE,20);


    public Griglia_personale(int numTurni) 
    {
        this.numTurni = numTurni;

        //Bottoni
        creaBottoni();

        creaNavi();

        stampaNavi();
        
        //panel
        testo.setBackground(new Color(255,255,255));
        testo.add(counter,BorderLayout.WEST);
        testo.add(info,BorderLayout.EAST);
        testo.add(info2,BorderLayout.EAST);
        testo.add(infoAffondata, BorderLayout.WEST);
        info.setFont(f);
        info.setText("Colpi sparati: 0/" + numTurni);
        info2.setFont(f);
        info2.setText("Punti colpiti: 0/15");
        counter.setFont(f);
        infoAffondata.setFont(f);
        
        infoAffondata.setText("Navi affondate: 0/5");

        //Frame
        add(panelCaselle, BorderLayout.CENTER);
        add(testo, BorderLayout.NORTH);
        setTitle("Battaglia navale");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 700);
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
                panelCaselle.add(bottone[i][j]);
            }
        }

        
    }

    public void creaNavi()
    {
        for(int i=0; i<10; i++)
        {
            for(int j=0; j<10; j++)
            {
                griglia[i][j] = false; //setta tutta la griglia su false perchè non ci sono ancora navi
            }
        }

        for(int i=0; i<5; i++) //creazione delle navi
        {
            //da spostare nel server
            do
            {
                indice = i;

                grandezza = i+1; //sceglie la grandezza

                orizontale = rand.nextBoolean(); //decide se è orizzontale o verticale

                if(orizontale == true) //orizzontale
                {
                    posizioneX[0][indice] = rand.nextInt(10);
                
                    if(posizioneX[0][indice] < 5)
                    {
                        for(int j=1; j<grandezza; j++)
                        {
                            posizioneX[j][indice] = posizioneX[j-1][indice] + 1;
                        }
                    }
                    else
                    {
                        for(int j=1; j<grandezza; j++)
                        {
                            posizioneX[j][indice] = posizioneX[j-1][indice] - 1;
                        }
                    }

                    posizioneY[0][indice] = rand.nextInt(10);
                }
                

                else    //verticale
                {
                    posizioneY[0][indice] = rand.nextInt(10);
                
                    if(posizioneY[0][indice] < 5)
                    {
                        for(int j=1; j<grandezza; j++)
                        {
                            posizioneY[j][indice] = posizioneY[j-1][indice] + 1;
                        }
                    }
                    else
                    {
                        for(int j=1; j<grandezza; j++)
                        {
                            posizioneY[j][indice] = posizioneY[j-1][indice] - 1;
                        }
                    }

                    posizioneX[0][indice] = rand.nextInt(10);
                }

            }while(controllaPosizione(posizioneX, posizioneY, indice, orizontale, grandezza) == false);
            //---------------------------------

            
            if(orizontale == true)
            {
                for(int j=0; j<grandezza; j++)
                {
                    griglia[posizioneX[j][indice]][posizioneY[0][indice]] = true; //inserisce nella griglia le navi
                }
            }
            else
            {
                for(int j=0; j<grandezza; j++)
                {
                    griglia[posizioneX[0][indice]][posizioneY[j][indice]] = true; //inserisce nella griglia le navi
                }
            }
            navi[i] = new Nave(posizioneX, posizioneY, indice,grandezza, orizontale);

        }
    }

    public boolean controllaPosizione(int[][] posizioneX, int[][] posizioneY, int indice, boolean orizontale, int grandezza) //ritorna true se la posizione della nave è libera
    {
        boolean controllaPosizione = true; 

        for(int i=0; i<grandezza; i++)
        {
            if(orizontale == true) //la nave è orizzontale
            {
                if(griglia[posizioneX[i][indice]][posizioneY[0][indice]] == true) //se è true vuol dire che c'è gia un'altra nave
                {
                    controllaPosizione = false; //lo mette a false per dire che lo spazio è gia occupato
                }
            }

            else //la nave è verticale
            {
                if(griglia[posizioneX[0][indice]][posizioneY[i][indice]] == true) //se è true vuol dire che c'è gia un'altra nave
                {
                    controllaPosizione = false; //lo mette a false per dire che lo spazio è gia occupato
                }
            }
        }

        return controllaPosizione;
    }

    public void stampaNavi()
    {
        for (int i = 0; i < griglia.length; i++) {
            for (int j = 0; j < griglia[0].length; j++) {
                if(griglia[i][j] == true)
                {
                    bottone[i+1][j+1].setBackground(new Color(178,28,59));
                }
            }
        }
    }

    public boolean controllaNavi(int x, int y)
    {
        boolean colpito = false;

        for(int i=0; i<5; i++)
        {
            if(navi[i].colpito(x, y) == true)
            {
                colpito = true;

                affondata = navi[i].affondata(); //controlla se la nave è stata affondata
            }
        }

        return colpito;
    }
}