import javax.swing.*;
import java.awt.*;

public class Vittoria_sconfitta extends JFrame
{
    
    JPanel testoRisultato = new JPanel();
    JLabel infoVittoria = new JLabel();
    JLabel info = new JLabel(new ImageIcon("Immagini/GAME-OVER.jpg"));
    Font f = new Font("Impact", Font.CENTER_BASELINE,60);

    public Vittoria_sconfitta(boolean vittoria_sconfitta)
    {
        if(vittoria_sconfitta==true)
        {
            testoRisultato.setBackground(new Color(0,0,0));
            testoRisultato.add(infoVittoria,BorderLayout.CENTER);
            setTitle("Vittoria");
            infoVittoria.setFont(f);
            infoVittoria.setForeground(Color.YELLOW);
            infoVittoria.setText("HAI VINTO !!!");
        }
        
        else if(vittoria_sconfitta==false)
        {
            testoRisultato.add(info,BorderLayout.CENTER);
            info.setIcon(new ImageIcon("Immagini/GAME-OVER.jpg"));
        }
        

        add(testoRisultato,BorderLayout.CENTER);
        setSize(400,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
