public class Nave 
{
    int[][] posizioneX;//righe
    int[][] posizioneY;//colonne

    int grandezza=0;

    int indice;

    int puntiColpiti = 0;

    boolean orizzontale=true; // se true è orizzontale se false è verticale


    public Nave(int posizioneX[][], int posizioneY[][], int indice, int grandezza, boolean orizontale)// costruttore di nave
    {

        this.orizzontale=orizontale;
        this.grandezza=grandezza;

        this.indice = indice;

        this.posizioneX=posizioneX;//dopo aver creato gli spazi per i dati della posizione li riempiamo
        this.posizioneY=posizioneY;
    }

    public boolean colpito(int x, int y)
    {// controlla se la nave è stata colpita
        boolean colpito = false;

        if(orizzontale==true) //orizzontale
        {
            if(posizioneY[0][indice] == y)
            {
                for(int i=0; i<grandezza; i++)
                {
                    if(posizioneX[i][indice] == x)
                    {
                        colpito = true;
                    }
                }
            }
        }
        else    //verticale
        {
            if(posizioneX[0][indice] == x)
            {
                for(int i=0; i<grandezza; i++)
                {
                    if(posizioneY[i][indice] == y)
                    {
                        colpito = true;
                    }
                }
            }
        }

        if(colpito == true) //segna quante volte è stata colpita la nave
        {
            puntiColpiti++;
        }

        return colpito;
    }


    public boolean affondata()
    {
        if(puntiColpiti == grandezza)
        {
            return true;
        }

        else
        {
            return false;
        }
    }
}
