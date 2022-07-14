// 2589561C
public class Play{

    public static void main(String[] args){

        Board board = new Board(10,5);

        Player player1 = new Player('S');

        HumanPlayer player2 = new HumanPlayer('D');

        board.addPlayer(player1);
        board.addPlayer(player2);

        // Add some deltas to the squares

        board.getSquare(22).setDelta(-6);
        board.getSquare(28).setDelta(3);
        board.getSquare(11).setDelta(-4);
        board.getSquare(40).setDelta(4);
        board.getSquare(38).setDelta(-3);
        board.getSquare(45).setDelta(-8);
        board.getSquare(30).setDelta(5);

        boolean gameWon;

        
        while(true){

            // Loop, printing board until gameWon == true
            gameWon = board.takeTurns();
            System.out.println(board);

            if(gameWon){
                System.out.println("Game has been won!");
                break;
            }

        }
    }
}