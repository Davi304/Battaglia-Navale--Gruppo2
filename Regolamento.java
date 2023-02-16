import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Regolamento extends JFrame implements ActionListener
{
    JPanel panelTurni = new JPanel(new GridLayout(1,2));
    JPanel panelRegolamento = new JPanel();
    JLabel regolamento[] = new JLabel[4];
    SpinnerModel valori = new SpinnerNumberModel(45,1,99,1);
    JSpinner turni = new JSpinner(valori);

    Font f = new Font("Comic Sans", Font.CENTER_BASELINE,15);
        
    JButton gioca = new JButton("Gioca");

    String[] testo = new String[4];
    

    public Regolamento()
    {
    
        for(int i=0; i<4; i++)
        {
            regolamento[i] = new JLabel();
            regolamento[i].setFont(f);
        }
        testo[0] = " Regolamento";
        regolamento[0].setText(testo[0]);
        testo[1] =" Hai un massimo di turni, dopo il quale se non hai affondato tutte le navi perdi. ( e' consigliato lasciare 45 turni)";
        regolamento[1].setText(testo[1]);
        testo[2] =" Devi affondare 5 navi ( 15 caselle in totale ) la grandezza delle navi puo' essere : 1; 2; 3; 4 oppure 5" ;
        regolamento[2].setText(testo[2]);
        testo[3] =" Se la nave viene colpita la casella diventera' rossa con una x in centro, se si colpisce a vuoto diventa azzurra";
        regolamento[3].setText(testo[3]);
        
        
        panelTurni.setBackground(Color.PINK);
        gioca.setFont(f);
        gioca.setBackground(new Color(255,128,0));
        gioca.addActionListener(this);

        turni.setFont(f);

        panelRegolamento.setBackground(new Color(255,255,255));
        panelRegolamento.add(regolamento[0]);
        panelRegolamento.add(regolamento[1]);
        panelRegolamento.add(regolamento[2]);
        panelRegolamento.add(regolamento[3]);


        panelTurni.add(turni);
        panelTurni.add(gioca);
       
        add(panelRegolamento, BorderLayout.CENTER);
        add(panelTurni, BorderLayout.SOUTH);
        setTitle("Regolamento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 300);
        setVisible(true);
        setLocationRelativeTo(null);

    }


    public void actionPerformed(ActionEvent e) 
    {
        int numTurni = (int) turni.getValue();

        try 
        {
            Thread.sleep(2000);
        } 
        catch (InterruptedException e1) 
        {
            e1.printStackTrace();
        }

        Griglia griglia = new Griglia(numTurni);
        dispose();
    }
    
}
