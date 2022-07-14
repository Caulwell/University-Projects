// 2589561C
public class Square{

    private int position;
    private Player[] playersLocatedHere = new Player[2];
    private int numPlayersHere = 0;
    private int delta = 0;

    public Square(int position, int delta){
        this.position = position;
        this.delta = delta;

    }

    public void assignPlayer(Player player){
        this.playersLocatedHere[numPlayersHere] = player;
        this.numPlayersHere++;
        player.setSquare(this);

    }


    public void setDelta(int delta){
        this.delta = delta;
    }

    public int getPosition(){
        return this.position;
    }

    public int getDelta(){
        return this.delta;
    }

    public void removePlayer(Player player){

        // loop through players array, if player is player to be removed, remove from this part of array, 
        // if another player, put this player in the first position of the array
        for(int i = 0; i<this.numPlayersHere; i++){
            if(this.playersLocatedHere[i] == player){
                this.playersLocatedHere[i] = null;
            } else if(this.playersLocatedHere[i] != player && this.playersLocatedHere[i] != null){
                this.playersLocatedHere[0] = this.playersLocatedHere[i];
            }
        }
        this.numPlayersHere--;
    }


    public String toString(){

        String playerString = "";
        
        for(int i=0; i<this.numPlayersHere; i++){
            playerString+=this.playersLocatedHere[i].toString();
        }

        String deltaString = "";

        if(this.delta != 0){
            deltaString += this.delta;
        }
            
        String returnedString = String.format("%2s %2d(  %2s)    ", playerString, this.position, deltaString);
        return returnedString;
    }  

}