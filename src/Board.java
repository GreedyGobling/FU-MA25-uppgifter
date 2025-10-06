import java.util.List;
import java.util.Scanner;

public class Board {
    char[][] gameboard = new char[3][3]; // 2d array
    public List<Data> dataList;
    int turn = 0;
    int turns = 0; // need for draw
    int winner;
    boolean gameOver = false;

    public Board(List<Data> dataList) {
        this.dataList = dataList;
    }

    public void beforeBattle() {
        GameBoard(); // reset gameboard to blanks
        turn = 0; // reset turn
        System.out.println("Battle started!");
        battle();
    }

    public void afterBattle() {
        if (winner == 0) {
            System.out.println(dataList.get(0).getName() + " wins!");
            dataList.get(0).setWins(dataList.get(0).getWins() + 1);
        } else if (winner == 1) {
            System.out.println(dataList.get(1).getName() + " wins!");
            dataList.get(1).setWins(dataList.get(1).getWins() + 1);
        } else {
            System.out.println("It's a draw!");
        }
        printBoard();
        System.out.println("Score: " + dataList.get(0).getName() + " " + dataList.get(0).getWins() + " - " + dataList.get(1).getWins() + " " + dataList.get(1).getName());
        System.out.println("Continue? (y/n)");
        Scanner sc = new Scanner(System.in);
        String inString = sc.nextLine();
        if (inString.equalsIgnoreCase("y")) {
            beforeBattle();
        } else {
            System.out.println("Thanks for playing!");
        }
        sc.close();
    }

    public void battle() {
        Scanner sc = new Scanner(System.in);
        try {
            for (gameOver = false; !gameOver; ) {
                printBoard();
                if (turn == 0) {
                    System.out.println(dataList.get(0).getName() + turn);
                    System.out.println("“Choose a tile by entering a number from 1 to 9");
                    int input = sc.nextInt();
                    int id = 0;
                    converter(input, id);
                    turn++;
                    turns++;
                    winner = 0;
                } else {
                    System.out.println(dataList.get(1).getName() + turn);
                    System.out.println("“Choose a tile by entering a number from 1 to 9");
                    int input = sc.nextInt();
                    int id = 1;
                    converter(input, id);
                    turn--;
                    turns++;
                    winner = 1;
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input, please enter a number from 1 to 9");
            sc.nextLine();
            battle();
        }
        sc.close();
        afterBattle();
    }

    public void converter(int input, int id) {
        int row = (input - 1) / 3; // get the row
        int col = (input - 1) % 3; // get the column
        char placeMarker = dataList.get(id).getCharacter().charAt(0); // get the character
        if (input < 1 || input > 9) {
            System.out.println("Invalid input, please enter a number from 1 to 9");
            draw();
            battle();
        } else if (gameboard[row][col] != ' ') {
            System.out.println("Cell already occupied, please choose another cell");
            draw();
            battle();
        } else {
            gameboard[row][col] = placeMarker; // place the mark
        }
        checkWin(id, placeMarker);
    }

    public void checkWin(int id, char placeMarker) {
        // TODO: check rows, columns and diagonals for a win
        for (int i = 0; i < gameboard.length; i++) {
            if (gameboard[i][0] == placeMarker && gameboard[i][1] == placeMarker && gameboard[i][2] == placeMarker) {
                gameOver = true;
            }
            if (gameboard[0][i] == placeMarker && gameboard[1][i] == placeMarker && gameboard[2][i] == placeMarker) {
                gameOver = true;
            }
            if (gameboard[0][0] == placeMarker && gameboard[1][1] == placeMarker && gameboard[2][2] == placeMarker) {
                gameOver = true;
            }
            if (gameboard[0][2] == placeMarker && gameboard[1][1] == placeMarker && gameboard[2][0] == placeMarker) {
                gameOver = true;
            }
        }
    }

    public void draw() {
        if (turns == 9 && gameOver == false) {
            System.out.println("It's a draw!");
            gameOver = true;
            winner = -1; // -1 for draw
        }
    }


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
