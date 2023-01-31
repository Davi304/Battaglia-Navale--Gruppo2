public class Nave 
{
    //La classe nave genera una nave che sa la propria posizione, la grandezza e capisce se è stata colpita

    int[] posizioneX;//righa
    int[] posizioneY;//colonne

    int grandezza=0;

    boolean orizzontale=true; // se true è orizzontale se false è verticale


    public Nave(int posizioneX[], int posizioneY[], int grandezza, boolean orizontale)
    {

        this.orizzontale=orizontale;
        this.grandezza=grandezza;

        if ( orizzontale= true){
            posizioneX= new int [grandezza];
            posizioneY= new int [1];
        }

        else{
            posizioneX= new int [1];
            posizioneY= new int [grandezza];
        }

        this.posizioneX=posizioneX;
        this.posizioneY=posizioneY;
    }

    public boolean colpito(int x, int y){
       
        if (orizzontale=true){

            if (posizioneY[0]==y){

                for (int i =0; i < grandezza; i ++){

                    if (posizioneX[i]==x){
                        return true;
                    }
                    
                }
            }
            else{
                return false;
            }
            return false;
        }

        else {

            if (posizioneX[0]==x){

                for (int j =0; j < grandezza; j ++){

                    if (posizioneY[j]==y){
                        return true;
                    }
                    
                }
            }
            else{
                return false;
            }
            return false;
        }
       
    }




}
