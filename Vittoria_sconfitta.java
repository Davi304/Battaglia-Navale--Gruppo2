import javax.swing.*;
import java.awt.*;

public class Vittoria_sconfitta extends JFrame
{
    JPanel testoRisultato = new JPanel(new GridLayout(3,3));
    JLabel info = new JLabel();
    Font f = new Font("Impact", Font.CENTER_BASELINE,25);

    public Vittoria_sconfitta(boolean vittoria_sconfitta)
    {
        if(vittoria_sconfitta==true){
            info.setFont(f);
            info.setText("HAI VINTO !!!");
        }
        
        else if(vittoria_sconfitta==false){
            info.setFont(f);
            info.setText("...HAI PERSO...");
        }
        

        add(testoRisultato,BorderLayout.CENTER);
        setSize(250,200);
        testoRisultato.setBackground(new Color(255,128,0));
        testoRisultato.add(info,BorderLayout.CENTER);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
