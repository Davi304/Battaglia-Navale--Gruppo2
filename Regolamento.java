import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Regolamento extends JFrame implements ActionListener
{
    JPanel panelTurni = new JPanel(new GridLayout(1,2));
    JPanel panelRegolamento = new JPanel();
    JLabel regolamento = new JLabel();
    //JTextField turni = new JTextField(15);
    SpinnerModel valori = new SpinnerNumberModel(45,1,99,1);
    JSpinner turni = new JSpinner(valori);

    Font f = new Font("Comic Sans", Font.CENTER_BASELINE,15);
        
    JButton gioca = new JButton("Gioca");

    String[] testo = new String[4];
    

    public Regolamento()
    {
        /*try 
        {
            File file = new File("regolamento.txt");
            Scanner scannerRegolamento = new Scanner(file);

            while(scannerRegolamento.hasNext())
            {
                testo += scannerRegolamento.nextLine();
            }

            scannerRegolamento.close();
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }*/

        testo[0] = " Regolamento";
        testo[1] =" Hai un massimo di turni, dopo il quale se non hai affondato tutte le navi perdi. ( e' consigliato lasciare 45 turni)";
        testo[2] =" Devi affondare 5 navi ( 15 caselle in totale ) la grandezza delle navi puo' essere : 1; 2; 3; 4 oppure 5" ;
        testo[3] =" Se la nave viene colpita la casella diventera' rossa con una x in centro, se si colpisce a vuoto diventa azzurra";
        
        regolamento.setFont(f);
        regolamento.setText(testo);

        gioca.setFont(f);
        gioca.setBackground(new Color(255,128,0));
        gioca.addActionListener(this);

        turni.setFont(f);

        panelRegolamento.add(regolamento);
<<<<<<< Updated upstream
        panelTurni.add(turni);
        panelTurni.add(gioca);
=======
        panelTurni();
>>>>>>> Stashed changes
        add(panelRegolamento, BorderLayout.CENTER);
        add(panelTurni, BorderLayout.SOUTH);
        setTitle("Regolamento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 600);
        setVisible(true);
        setLocationRelativeTo(null);

    }


    public void actionPerformed(ActionEvent e) 
    {
        int numTurni = (int) turni.getValue();

        //da completare
    }
    
}
