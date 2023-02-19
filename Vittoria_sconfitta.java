import javax.swing.*;
import java.awt.*;

public class Vittoria_sconfitta extends JFrame
{
    
    JPanel testoRisultato = new JPanel();
    JLabel infoVittoria = new JLabel(new ImageIcon("Immagini/Vittoria.png"));
    JLabel infoSconfitta = new JLabel(new ImageIcon("Immagini/Game-over.png"));
    //Font f = new Font("Impact", Font.CENTER_BASELINE,60);

    public Vittoria_sconfitta(boolean vittoria_sconfitta)
    {
        if(vittoria_sconfitta==true)
        {
            
            testoRisultato.add(infoVittoria,BorderLayout.CENTER);
            setTitle("Vittoria");
            infoVittoria.setIcon(new ImageIcon("Immagini/Vittoria.png"));
            setSize(900,500);
        }
        
        else if(vittoria_sconfitta==false)
        {
            setTitle("Sconfitta");
            testoRisultato.add(infoSconfitta,BorderLayout.CENTER);
            infoSconfitta.setIcon(new ImageIcon("Immagini/Game-over.png"));
            setSize(650,430);
        }
        
        add(testoRisultato,BorderLayout.CENTER);
        
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
