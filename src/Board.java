import java.util.List;
import java.util.Scanner;

public class Board {
    char[][] gameboard = new char[3][3]; // 2d array
    public List<Data> dataList;
    int turn = 0;
    boolean gameOver = false;

    public Board(List<Data> dataList) {
        this.dataList = dataList;
    }

    public void beforeBattle() {
        GameBoard();
        System.out.println("Battle started!");
        battle();
    }

    public void battle() {
        Scanner sc = new Scanner(System.in);
        try {
            for (gameOver = false; !gameOver; ) {
                printBoard();
                if (turn == 0) {
                    System.out.println(dataList.get(0).getName() + turn);
                    System.out.println("“Choose a tile by entering a number from 1 to 9");
                    turn++;
                } else {
                    System.out.println(dataList.get(1).getName() + turn);
                    turn--;
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input, please enter a number from 1 to 9");
            sc.nextLine();
            battle();
        }
        sc.close();
    }


    //TODO: create a method to check for a win or drawn
    //TODO: create a method to place a mark on the gameboard
    //TODO: create a method to check if a cell is already occupied
    public void GameBoard() {
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard.length; j++) {
                gameboard[i][j] = ' '; // fill the gameboard with empty spaces
            }
        }
    }

    public void printBoard() { // print the gameboard to the console
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
