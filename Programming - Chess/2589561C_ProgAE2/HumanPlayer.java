// 2589561C
import java.util.Scanner;
public class HumanPlayer extends Player{


    public HumanPlayer(char playerID){
        super(playerID);
    
    }

    public boolean move(Board b){

        System.out.println("Enter an integer between 1 and 6");

        Scanner s = new Scanner(System.in);

        int userInput = s.nextInt();

        // Wait for valid user input if first invalid
        while(userInput < 0 || userInput > 6){
            System.out.println("Enter an integer between 1 and 6");
            userInput = s.nextInt();
        }

        // Remove Player from current square
        Square currentSquare = this.currentLocation;
        currentSquare.removePlayer(this);

        // Get new position after input
        int newLocation = currentSquare.getPosition() + userInput;

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

        // Assign player to square
        newSquare.assignPlayer(this);

        // If new square == last square return true, otherwise false
        if(newSquare.getPosition() == numSquares -1){
            return true;
        }else {
            return false;
        }
    }
}