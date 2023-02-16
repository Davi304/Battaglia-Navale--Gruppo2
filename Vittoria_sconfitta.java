import javax.swing.*;
import java.awt.*;

public class Vittoria_sconfitta extends JFrame
{
    JPanel testoRisultato = new JPanel();
    JLabel info = new JLabel();
    Font f = new Font("Comic Sans", Font.CENTER_BASELINE,20);

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
        testoRisultato.add(info,BorderLayout.CENTER);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
