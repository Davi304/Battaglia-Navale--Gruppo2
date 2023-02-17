import javax.swing.*;
import java.awt.*;

public class Vittoria_sconfitta extends JFrame
{
    
    JPanel testoRisultato = new JPanel();
    JLabel info = new JLabel();
    Font f = new Font("Impact", Font.CENTER_BASELINE,60);

    public Vittoria_sconfitta(boolean vittoria_sconfitta)
    {
        if(vittoria_sconfitta==true)
        {
            setTitle("Vittoria");
            info.setFont(f);
            info.setForeground(Color.YELLOW);
            info.setText("HAI VINTO !!!");
        }
        
        else if(vittoria_sconfitta==false)
        {
            setTitle("Sconfitta");
            info.setFont(f);
            info.setForeground(Color.RED);
            info.setText("...GAME OVER...");
        }
        

        add(testoRisultato,BorderLayout.CENTER);
        setSize(400,300);
        testoRisultato.setBackground(new Color(0,0,0));
        testoRisultato.add(info,BorderLayout.CENTER);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
