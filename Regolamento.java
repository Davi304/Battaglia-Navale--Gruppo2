import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Regolamento extends JFrame implements ActionListener
{
    JPanel panelTurni = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
    JPanel panelRegolamento = new JPanel();
    JLabel regolamento[] = new JLabel[4];
    SpinnerModel valori = new SpinnerNumberModel(45,1,99,1);
    JSpinner turni = new JSpinner(valori);

    Font f = new Font("Comic Sans", Font.CENTER_BASELINE,16);
    Font f2 = new Font("Arial", Font.CENTER_BASELINE,20);
    
    JButton gioca = new JButton("Gioca");
    
    String[] testo = new String[4];
    

    public Regolamento()
    {

        //regolamento
        gioca.setForeground(Color.WHITE);
        for(int i=0; i<4; i++)
        {
            regolamento[i] = new JLabel();
            regolamento[i].setFont(f);
        }
        regolamento[0].setFont(f2);
        testo[0] = " REGOLAMENTO :\n";
        regolamento[0].setText(testo[0]);
        regolamento[0].setForeground(Color.WHITE);

        testo[1] =" Hai un massimo di turni, dopo il quale se non hai affondato tutte le navi perdi. ( e' consigliato lasciare 45 turni)";
        regolamento[1].setText(testo[1]);
        testo[2] =" Devi affondare 5 navi ( 15 caselle in totale ) la grandezza delle navi puo' essere : 1; 2; 3; 4 oppure 5" ;
        regolamento[2].setText(testo[2]);
        testo[3] =" Se la nave viene colpita la casella diventera' rossa con una 'X' in centro, se si colpisce a vuoto diventa azzurra";
        regolamento[3].setText(testo[3]);
        
        //tasto
        panelTurni.setBackground(Color.PINK);
        gioca.setFont(f);
        gioca.setBackground(new Color(38,97,155));
        gioca.addActionListener(this);

        //spinner
        turni.setFont(f);

        //panel
        panelRegolamento.setBackground(new Color(255,122,122));
        panelRegolamento.add(regolamento[0]);
        panelRegolamento.add(regolamento[1]);
        panelRegolamento.add(regolamento[2]);
        panelRegolamento.add(regolamento[3]);

        panelTurni.add(turni);
        panelTurni.add(gioca);
        panelTurni.setBackground(new Color(255,122,122));
       
        //frame
        add(panelRegolamento, BorderLayout.CENTER);
        add(panelTurni, BorderLayout.SOUTH);
        setTitle("Regolamento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 200);
        setVisible(true);
        setLocationRelativeTo(null);

    }


    public void actionPerformed(ActionEvent e) 
    {
        int numTurni = (int) turni.getValue();

        try 
        {
            Thread.sleep(500);
        } 
        catch (InterruptedException e1) 
        {
            e1.printStackTrace();
        }

        Griglia griglia = new Griglia(numTurni);
        dispose();
    }
    
}
