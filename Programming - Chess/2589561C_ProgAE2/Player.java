// 2589561C
import java.util.Random;
public class Player{


    private char playerID;
    protected Square currentLocation;


    public Player(char playerID){
        this.playerID = playerID;
    }

    public void setSquare(Square square){
        this.currentLocation = square;
    }


    public String toString(){
        return Character.toString(playerID);
    }


    public boolean move(Board b){
        
        // Remove player from current square
        Square currentSquare = this.currentLocation;
        currentSquare.removePlayer(this);

        // Get new position using current position + random int
        Random r = new Random();
        int count = r.nextInt(6) + 1;
        int newLocation = this.currentLocation.getPosition() + count;

        Square newSquare;

        int numSquares = b.getNumSquares();

        // If new location above the last point of board, new location is last point
        if(newLocation > numSquares -1){
            newSquare = b.getSquare(numSquares-1);
        } else {
            newSquare = b.getSquare(newLocation);
        }

        // Check delta and get square using delta
        if(newSquare.getDelta() != 0){
            newSquare = b.getSquare(newLocation + newSquare.getDelta());
        }

        // Assign player to new square
        newSquare.assignPlayer(this);

        // If new square == last square return true, otherwise false
        if(newSquare.getPosition() == numSquares -1){
            System.out.println("Winner: " + this.playerID);
            return true;
        }else {
            return false;
        }

    }

    public static void main(String[] args){

        Player player1 = new Player('S');

        Square square1 = new Square(12, 0);

        square1.assignPlayer(player1);

        System.out.println(player1);
        System.out.println(square1);

    }

}