import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;



public class Griglia extends JFrame implements ActionListener
{
    //La classe griglia crea la griglia di gioco con le matrici che stava facendo Andrea
    
    public final int numTurni=30;

    JPanel panelCaselle = new JPanel(new GridLayout(11,11));
    JPanel testo = new JPanel(new GridLayout(1,1));
    JLabel counter = new JLabel(), info = new JLabel();
    Bottoni[][] bottone = new Bottoni[11][11];
    Nave navi[] = new Nave[5];
    Random rand = new Random();
    int grandezza, posizioneX[][] = new int[5][5], posizioneY[][] = new int[5][5];
    int x,y, indice;
    int contatore=0;
    boolean orizontale;
    boolean[][] griglia = new boolean[10][10];
    Font f = new Font("Comic Sans", Font.BOLD,20);


    public Griglia()
    {
        //Bottoni
        for(int i=1; i<11; i++)
        {
            for(int j=1; j<11; j++)
            {
                bottone[i][j] = new Bottoni((i-1), (j-1));
                bottone[i][j].setBackground(Color.BLUE);
                bottone[i][j].setFont(f);
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
        for(int i=0; i<11; i++){
            bottone[0][i].setFont(f);
            bottone[0][i].setBackground(new Color(255,128,0));

        }
        for(int i=1; i<11; i++)
        {
            bottone[i][0] = new Bottoni("" + i);
            bottone[i][0].setBackground(new Color(255,128,0));
            bottone[i][0].setFont(f);
        }

        bottone[0][0].setBackground(Color.WHITE);

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
                indice = i;

                for(int h=0; h<5; h++)
                {
                    posizioneX[h][indice] = 0;
                    posizioneY[h][indice] = 0;
                }
                
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

        
        //Frame
        add(panelCaselle, BorderLayout.CENTER);
        add(testo, BorderLayout.NORTH);
        testo.add(counter,BorderLayout.WEST);
        testo.add(info,BorderLayout.EAST);
        setTitle("Battaglia navale");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 600);
        setVisible(true);
        setLocationRelativeTo(null);


        controllaVittoria();
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

    public void controllaVittoria()
    {
        boolean vittoria = false;

        while(vittoria == false)
        {
            if(contatore == numTurni)
            {
                vittoria = true;
            }

            /*if(tutteAffondate() == true)
            {
                vittoria = true;
            }*/
        }

        //aprire una nuova finestra che dice hai vinto
        //chiudere la finestra dopo tot secondi
    }

    public void actionPerformed(ActionEvent e) 
    {
        boolean colpito = false;

        if(e.getSource() instanceof Bottoni) //capisce se è stato premuto un bottone
        {
            if( ((Bottoni) e.getSource()).getPremuto() == false) //controlla se il bottone è stato premuto
            {
                contatore++;
                //prendo i valori della x e della y del bottone schiacciato
                x = ((Bottoni) e.getSource()).getCoordinataX();
                y = ((Bottoni) e.getSource()).getCoordinataY();

                ((Bottoni) e.getSource()).pulsantePremuto(); //segn il pulsante come premuto
            

                for(int i=0; i<5; i++)
                {
                    if(navi[i].colpito(x, y) == true)
                    {
                        colpito = true;
                    }
                }
            
                
                if(colpito == true)
                {
                    ((Bottoni) e.getSource()).setBackground(Color.RED);                    
                    ((Bottoni) e.getSource()).setText("O");
                    counter.setFont(f);
                    counter.setText("COLPITO !!!");
                }
                else
                {
                    ((Bottoni) e.getSource()).setBackground(Color.CYAN);
                    counter.setFont(f);
                    counter.setText("ACQUA...");

                }
            }

            else
            {
                //Il pulsante è gia stato premuto
            }
        }
        
      
    }
}