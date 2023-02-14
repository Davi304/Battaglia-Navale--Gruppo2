import javax.swing.*;
import java.awt.*;

public class Vittoria_sconfitta extends Griglia
{
    JPanel testoRisultato = new JPanel();
    JLabel info3 = new JLabel();
    Font f = new Font("Comic Sans", Font.CENTER_BASELINE,20);

    public Vittoria_sconfitta(boolean vittoria_sconfitta)
    {
        
        if(vittoria_sconfitta==true){
            info3.setFont(f);
            info3.setText("HAI VINTO !!!");
            setVisible(true);
        }
        
        else if(vittoria_sconfitta==false){
            info3.setFont(f);
            info3.setText("...HAI PERSO...");
            setVisible(false);
        }
        

        add(testoRisultato,BorderLayout.CENTER);
        setSize(100,90);
        add(info3,BorderLayout.CENTER);
        setVisible((false));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
