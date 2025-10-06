import java.util.List;
import java.util.Scanner;

public class Board {
    char[][] gameboard = new char[3][3]; // 2d array
    public List<Data> dataList;
    int turn = 0;
    int turns = 0; // need for draw
    int winner;
    boolean isDraw = false;
    boolean gameOver = false;
    Scanner sc = new Scanner(System.in);

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
        printBoard();
        System.out.println("Score: " + dataList.get(0).getName() + " " + dataList.get(0).getWins() + " - " + dataList.get(1).getWins() + " " + dataList.get(1).getName());
        continyOrEnd();
        sc.close();
    }

    public void battle() {
        try {
            for (gameOver = false; !gameOver; ) {
                printBoard();
                if (turn == 0) {
                    System.out.println(dataList.get(0).getName() + turn);
                    System.out.println("“Choose a tile by entering a number from 1 to 9");
                    int input = sc.nextInt();
                    int id = 0;
                    converter(input, id);
                    checkGame(id);
                    turn++;
                    turns++;
                } else {
                    System.out.println(dataList.get(1).getName() + turn);
                    System.out.println("“Choose a tile by entering a number from 1 to 9");
                    int input = sc.nextInt();
                    int id = 1;
                    converter(input, id);
                    checkGame(id);
                    turn--;
                    turns++;
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input, please enter a number from 1 to 9");
            sc.nextLine();
            battle();
        }
        afterBattle();
    }

    public void converter(int input, int id) {
        int row = (input - 1) / 3; // get the row
        int col = (input - 1) % 3; // get the column
        char placeMarker = dataList.get(id).getCharacter().charAt(0); // get the character
        draw();
        if (isDraw == false) {
            if (input < 1 || input > 9) {
                System.out.println("Invalid input, please enter a number from 1 to 9");
                battle();
            } else if (gameboard[row][col] != ' ') {
                System.out.println("Cell already occupied, please choose another cell");
                battle();
            } else {
                gameboard[row][col] = placeMarker; // place the mark
            }
        }
        checkWin(id, placeMarker);
    }

    public void checkGame(int id) {
        if (checkWin(id, dataList.get(id).getCharacter().charAt(0))) {
            gameOver = true;
            System.out.println(dataList.get(id).getName() + " wins!");
            dataList.get(id).setWins(dataList.get(id).getWins() + 1);
            afterBattle();
        } else if (draw()) {
            gameOver = true;
            System.out.println("Draw!");
            continyOrEnd();
        }
    }

    public boolean checkWin(int id, char placeMarker) {
        for (int i = 0; i < gameboard.length; i++) {
            if (gameboard[i][0] == placeMarker && gameboard[i][1] == placeMarker && gameboard[i][2] == placeMarker) {
                return true;
            }
            if (gameboard[0][i] == placeMarker && gameboard[1][i] == placeMarker && gameboard[2][i] == placeMarker) {
                return true;
            }
            if (gameboard[0][0] == placeMarker && gameboard[1][1] == placeMarker && gameboard[2][2] == placeMarker) {
                return true;
            }
            if (gameboard[0][2] == placeMarker && gameboard[1][1] == placeMarker && gameboard[2][0] == placeMarker) {
                return true;
            }
        }
        return false;
    }

    //    public void draw() {
//        if ( && gameOver == false) {
//            System.out.println("It's a draw!");
//            gameOver = true;
//            isDraw = true;
//            winner = -1; // -1 for draw
//
//        }
//    }
    public boolean draw() {
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard.length; j++) {
                if (gameboard[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }


    public void GameBoard() {
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard.length; j++) {
                gameboard[i][j] = ' '; // fill the gameboard with empty spaces
            }
        }
    }

    public void continyOrEnd(){
        System.out.println("Continue? (y/n)");
        sc.nextLine().toUpperCase();
        String inString = sc.nextLine();
        if (inString.equalsIgnoreCase("y")) {
            beforeBattle();
        } else {
            System.out.println("Thanks for playing!");
        }
        sc.close();
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
