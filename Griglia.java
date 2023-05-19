import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;


public class Griglia extends JFrame implements ActionListener
{
    //client
    int serverPort = 2000;
    InetAddress serverAddress;
    DatagramSocket dSocket;
    DatagramPacket outPacket;
    DatagramPacket inPacket;
    byte[] buffer;


    //
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
    Griglia_personale griglia_personale = new Griglia_personale(numTurni);

    public Griglia(int numTurni)
    {
        this.numTurni = numTurni;

        //Bottoni
        creaBottoni();

        
        
     
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
                panelCaselle.add(bottone[i][j]);
                
            }
        }
    }

  
//----------------------
    public void controllaVittoria()
    {

        if(contatore2 == 15)
        {
            try 
            {
                Thread.sleep(500);
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
            setVisible(false);
            Vittoria_sconfitta vittoria_sconfitta = new Vittoria_sconfitta(true);
        }

        if(contatore == numTurni)
        {
            
            try 
            {
                Thread.sleep(500);
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
            setVisible(false);
            Vittoria_sconfitta vittoria_sconfitta= new Vittoria_sconfitta(false);
        }
    }

    public void actionPerformed(ActionEvent e) 
    {
        boolean colpito = false;
        affondata = false; //resetta affondata

        if(e.getSource() instanceof Bottoni) //capisce se è stato premuto un bottone
        {
            if( ((Bottoni) e.getSource()).getPremuto() == false) //controlla se il bottone è già stato premuto
            {

                //aumenta il contatore
                contatore++;
                info.setText("Colpi sparati: " + contatore + "/" + numTurni);
                

                //prendo i valori della x e della y del bottone schiacciato
                x = ((Bottoni) e.getSource()).getCoordinataX();
                y = ((Bottoni) e.getSource()).getCoordinataY();

                ((Bottoni) e.getSource()).pulsantePremuto(); //segna il pulsante come premuto
                
                //invia le coordinate
                try
                {
                    dSocket = new DatagramSocket();
                }
                catch(IOException a)
                {
                    System.out.println(a);
                }


                //attende risposta e modifica la griglia personale

                //aspetta le coordinate dell'altro

                //controlla se è colpito o affondato e risponde
               
                colpito = griglia_personale.controllaNavi(x, y);

                //se la nave è stata affondata lo segna
                if(affondata == true)
                {
                    numNaviAffondate++;
                    infoAffondata.setText("Navi affondate: " + numNaviAffondate + "/5");
                }
                         
                if(colpito == true)
                {
                    contatore2++;
                    //bottone
                    ((Bottoni) e.getSource()).setBackground(new Color(178,28,59)); 
                    ((Bottoni) e.getSource()).setFont(f);                  
                    ((Bottoni) e.getSource()).setText("X");

                    //testi
                    counter.setText("COLPITO !!!");
                    info2.setText("Punti colpiti: " + contatore2 + " /15 ");
                }
                else
                {
                    //bottone
                    ((Bottoni) e.getSource()).setBackground(new Color(38,97,155));

                    //testo
                    counter.setText("ACQUA...");
                }

                //funzione per controllare se si ha vinto
                controllaVittoria();
            }

            else
            {
                //Il pulsante è gia stato premuto
            }
        }
        
      
    }
}