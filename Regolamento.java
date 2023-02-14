import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Regolamento extends JFrame implements ActionListener
{
    JPanel panelTurni = new JPanel(new GridLayout(1,2));
    JPanel panelRegolamento = new JPanel();
    JLabel regolamento = new JLabel();
    JTextField turni = new JTextField();
    JButton gioca = new JButton("Gioca");

    public Regolamento()
    {
        

        panelRegolamento.add(regolamento);
        panelTurni
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
       
    }
    
}
