public class Board {
    char[][] gameboard = new char[3][3]; // 2d array
    public void start() {
        printBoard();
    }
    public void printBoard(){ // print the gameboard to the console
        for (int i = 0; i < gameboard.length; i++) { // iterate through the rows
            for (int j = 0; j < gameboard.length; j++) { // iterate through the columns
//                System.out.println("cell" + " " + i + " " + j);
                System.out.print(gameboard[i][0] + " | " + gameboard[i][1] + " | " + gameboard[i][2]);
                if (i < 1 ) System.out.println("-------");
            }
        }
    }
}
