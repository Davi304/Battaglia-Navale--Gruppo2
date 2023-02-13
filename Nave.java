public class Nave 
{
    //La classe nave genera una nave che sa la propria posizione, la grandezza e capisce se è stata colpita

    int[][] posizioneX;//righa
    int[][] posizioneY;//colonne

    int grandezza=0;

    int indice;

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
       
        if (orizzontale=true)
        {// se orizzontale la y sarà una e la x sarà >1

            if (posizioneY[0][indice]==y)
            {

                for (int i =0; i < grandezza; i ++)
                {

                    if (posizioneX[i][indice]==x)
                    {
                        return true;
                    }
                    
                }
            }
            else
            {
                return false;
            }
            return false;
        }

        else 
        {// il contrario di sopra 

            if (posizioneX[0][indice]==x)
            {

                for (int j =0; j < grandezza; j ++)
                {
                    if (posizioneY[j][indice]==y)
                    {
                        return true;
                    }
                }
            }
            else
            {
                return false;
            }
            return false;
        }
    }

}
