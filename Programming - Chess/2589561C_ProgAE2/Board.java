// 2589561C
public class Board{

    private int rows;
    private int columns;
    private int numSquares;
    private Square[][] squares;
    private int numPlayers = 0;
    private Player[] players = new Player[2];

    public Board(int rows, int columns){
        this.rows = rows;
        this.columns = columns;

        this.squares = new Square[rows][columns];

        int columnCounter = this.columns;
        
        // Add reference to squares
        for(int i = 0; i<this.rows; i++){
            //For every row
            int t = 0;
            for(int j = columnCounter - this.columns; j <columnCounter; j++){
                // For every column
                Square newSquare = new Square(j, 0);
                this.squares[i][t] = newSquare;
                t++;
            }
            columnCounter += this.columns; 
        }  

        this.numSquares = rows*columns;
    }

    // HELPER METHODS

    public int getNumSquares(){
        return this.numSquares;
    }

    public String getRowAndColumn(int position){

        String rowAndColumn = "";

        for(int i = 0; i < this.squares.length; i++){
            for(int j = 0; j < this.squares[i].length; j++){
                if(this.squares[i][j].getPosition() == position){
                    rowAndColumn = "Row: " + i + " Column: " + j;
                }
            }
        }
        return rowAndColumn;
    }

    public int getPosition(int row, int column){
        return this.squares[row][column].getPosition();
    }

    public Square getSquare(int position){

        Square returnedSquare = null;

        for(int i = 0; i < this.squares.length; i++){
            for(int j = 0; j < this.squares[i].length; j++){
                if(this.squares[i][j].getPosition() == position){
                    returnedSquare = this.squares[i][j];
                }
            }
        }

        return returnedSquare;
        
    }

    // FUNCTIONAL METHODS

    public void addPlayer(Player player){
        this.players[numPlayers] = player;
        this.squares[0][0].assignPlayer(player);
        this.numPlayers++;
    }

   
    public boolean takeTurns(){

        boolean methodResult;

        boolean gameWon = false;

        for(int i = 0; i<this.numPlayers; i++){
            methodResult = players[i].move(this);
            if(methodResult == true){
                gameWon = true;
            }
        }
        return gameWon;
    }



    public String toString(){

        String returnString = "";
        Square[][] squaresCopy = new Square[this.rows][this.columns];

        // Copy squares array

        for(int i = 0; i < this.squares.length; i++){
            for(int j = 0; j < this.squares[i].length; j++){
                squaresCopy[i][j] = this.squares[i][j];
            }
        }
        
        // Reverse whole Array
        for (int i = 0; i < squaresCopy.length / 2; i++) {
            Square temp[] = squaresCopy[i];
            squaresCopy[i] = squaresCopy[squaresCopy.length - 1 - i];
            squaresCopy[squaresCopy.length - 1 - i] = temp;
        }

        // For each row in array - if row num is divisible by 2, reverse the contents
        for(int i = 0; i < squaresCopy.length; i++){
            Square[] row = squaresCopy[i];
            if(i % 2 == 0){
                for (int j = 0; j < row.length / 2; j++) {
                    Square temp = row[j];
                    row[j] = row[row.length - 1 - j];
                    row[row.length - 1 - j] = temp;
                }
            }
            // Replace squareCopy row with new, reversed row
            squaresCopy[i] = row;
            // Add contents of square array to return string, printing a new line every row
            for(int j = 0; j < squaresCopy[i].length; j++ ){
                returnString += squaresCopy[i][j];
            }
            returnString += "\n";
        }
        return returnString;
    }  
    
    public static void main(String[] args){

        Board board1 = new Board(10,5);

        Player player1 = new Player('D');
        Player player2 = new Player('F');

        board1.addPlayer(player1);
        board1.addPlayer(player2);


        System.out.println(board1);

    }
}