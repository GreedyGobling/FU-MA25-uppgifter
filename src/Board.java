public class Board {
    char[][] gameboard = new char[3][3]; // 2d array

    public void print() {
        GameBoard();
        printBoard();
    }
    //TODO: create a method to reset the gameboard
    //TODO: create a method to check for a win
    //TODO: create a method to check for a draw
    //TODO: create a method to place a mark on the gameboard
    //TODO: create a method to check if a cell is already occupied
    //TODO: create a method to place a mark on the gameboard
    private void GameBoard() {
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard.length; j++) {
                gameboard[i][j] = ' ';
            }
        }
    }

    private void printBoard() { // print the gameboard to the console
        for (int i = 0; i < gameboard.length; i++) { // through the rows
//            for (int j = 0; j < gameboard.length; j++) { // through the columns
//                  System.out.println("cell" + " " + i + " " + j);
            if (i == 0) System.out.println("|-----------|");
            System.out.print("| " + gameboard[i][0] + " | " + gameboard[i][1] + " | " + gameboard[i][2] + " |" + "\n");
            if (i < 2) System.out.println("|---+---+---|");
            if (i == 2) System.out.println("|-----------|");
        }
    }
}
