import javax.swing.*;

public class Bottoni extends JButton
{
    //La classe bottoni la usiamo per creare la griglia di bottoni
    
    private int x;
    private int y;
    private boolean premuto;

    public Bottoni(int x, int y, ImageIcon icona) //crea i bottoni del mare
    {
        this.x = x;
        this.y = y;

        this.setIcon(icona);

        premuto = false;
    }

    public Bottoni(String testo) //crea i bottoni del testo
    {
        this.x = 11; //lo mettiamo a 11 perchè non serve per le navi
        this.y = 11;

        this.setText(testo);
    }

    public int getCoordinataX()
    {
        return x;
    }

    public int getCoordinataY()
    {
        return y;
    }
    
    public boolean getPremuto()
    {
        return premuto;
    }

    public void pulsantePremuto()
    {
        premuto = true;
    }
}
