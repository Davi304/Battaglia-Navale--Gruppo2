import javax.swing.*;

public class Bottoni extends JButton
{
    //La classe bottoni la usiamo per creare la griglia di bottoni
    
    int x;
    int y;

    public Bottoni(int x, int y, ImageIcon icona) //crea i bottoni del mare
    {
        this.x = x;
        this.y = y;

        this.setIcon(icona);
    }

    public Bottoni(String testo) //crea i bottoni del testo
    {
        this.x = 11; //lo mettiamo a 11 perchè non serve per le navi
        this.y = 11;

        this.setText(testo);
    }

    
}
