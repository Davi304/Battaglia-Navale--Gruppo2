public class Nave 
{
    //La classe nave genera una nave che sa la propria posizione, la grandezza e capisce se è stata colpita

    int[] posizioneX;//righa
    int[] posizioneY;//colonne

    int grandezza=0;

    boolean orizzontale=true; // se true è orizzontale se false è verticale


    public Nave(int posizioneX[], int posizioneY[], int grandezza, boolean orizontale)// costruttore di nave
    {

        this.orizzontale=orizontale;
        this.grandezza=grandezza;

        if ( orizzontale= true)
        {// in caso sia orizzontale allora entra nel if 
            posizioneX= new int [grandezza];
            posizioneY= new int [1];
        }

        else{// in caaso sia verticale entra nell'else
            posizioneX= new int [1];
            posizioneY= new int [grandezza];
        }

        this.posizioneX=posizioneX;//dopo aver creato gli spazi per i dati della posizione li riempiamo
        this.posizioneY=posizioneY;
    }

    public boolean colpito(int x, int y)
    {// controlla se la nave è stata colpita
       
        if (orizzontale=true)
        {// se orizzontale la y sarà una e la x sarà >1

            if (posizioneY[0]==y)
            {

                for (int i =0; i < grandezza; i ++)
                {

                    if (posizioneX[i]==x)
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

            if (posizioneX[0]==x)
            {

                for (int j =0; j < grandezza; j ++)
                {
                    if (posizioneY[j]==y)
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
