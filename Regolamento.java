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

    String testo = "regolamento";

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

        regolamento.setFont(f);
        regolamento.setText(testo);

        gioca.setFont(f);
        gioca.setBackground(new Color(255,128,0));
        gioca.addActionListener(this);

        turni.setFont(f);

        panelRegolamento.add(regolamento);
        panelTurni.add(turni);
        panelTurni.add(gioca);
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
