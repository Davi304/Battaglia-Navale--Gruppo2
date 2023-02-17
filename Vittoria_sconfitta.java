import javax.swing.*;
import java.awt.*;

public class Vittoria_sconfitta extends JFrame
{
    
    JPanel testoRisultato = new JPanel();
    JLabel infoVittoria = new JLabel(new ImageIcon("Immagini/Vittoria.png"));
    JLabel info = new JLabel(new ImageIcon("Immagini/GAME-OVER.jpg"));
    //Font f = new Font("Impact", Font.CENTER_BASELINE,60);

    public Vittoria_sconfitta(boolean vittoria_sconfitta)
    {
        if(vittoria_sconfitta==true)
        {
            
            testoRisultato.add(infoVittoria,BorderLayout.CENTER);
            setTitle("Vittoria");
            infoVittoria.setIcon(new ImageIcon("Immagini/Vittoria.png"));

        }
        
        else if(vittoria_sconfitta==false)
        {
            setTitle("Sconfitta");
            testoRisultato.add(info,BorderLayout.CENTER);
            info.setIcon(new ImageIcon("Immagini/GAME-OVER.jpg"));
        }
        
        add(testoRisultato,BorderLayout.CENTER);
        setSize(639,400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
