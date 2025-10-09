import java.util.List;
import java.util.Scanner;

public class Board {
    char[][] gameboard = new char[3][3]; // 2d array
    public List<Player> players;
    int turn = 0;
    boolean gameOver = false;
    Scanner sc = new Scanner(System.in);

    public Board(List<Player> players) {
        this.players = players;
    }

    public void battle() {
        try {
            for (gameOver = false; !gameOver; ) {
                printBoard();
                if (turn == 0) {
                    players(0);
                    turn++;
                } else {
                    if (players.get(1).getName().equals("AI925")) {
                        randomBot(1);
                    } else {
                        players(1);
                    }
                    turn--;
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
        char placeMarker = players.get(id).getSymbol().charAt(0); // get the character
        isDraw();
//        if (!endDraw) {
            if (input < 1 || input > 9) {
                System.out.println("Invalid input, please enter a number from 1 to 9");
                battle();
            } else if (gameboard[row][col] != ' ') {
                System.out.println("Cell already occupied, please choose another cell");
                battle();
            } else {
                gameboard[row][col] = placeMarker; // place the mark
            }
//        }
    }

    public void checkGame(int id) {
        if (checkWin(players.get(id).getSymbol().charAt(0))) {
            gameOver = true;
            System.out.println(players.get(id).getName() + " wins!");
            players.get(id).setWins(players.get(id).getWins() + 1);
            afterBattle();
        } else if (isDraw()) {
            gameOver = true;
            System.out.println("Draw!");
            continyOrEnd();
        }
    }

    public boolean checkWin(char placeMarker) {
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

    public boolean isDraw() { // check for full board
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard.length; j++) {
                if (gameboard[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void randomBot(int id) {
        int row, col;
        do {
            row = (int) (Math.random() * 3);
            col = (int) (Math.random() * 3);
        } while (gameboard[row][col] != ' ');
        char placeMarker = players.get(id).getSymbol().charAt(0);
        gameboard[row][col] = placeMarker; // place the mark
        checkGame(id);
    }

    public void players(int id) {
        System.out.println(players.get(id).getName() + turn);
        System.out.println("“Choose a tile by entering a number from 1 to 9");
        int input = sc.nextInt();
        sc.nextLine();
        converter(input, id);
        checkGame(id);
    }

    public void resetBoard() {
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard.length; j++) {
                gameboard[i][j] = ' '; // fill the gameboard with empty spaces
            }
        }
    }

    public void continyOrEnd() {
        System.out.println("Continue? (y/n)");
        String inString = sc.nextLine();
        if (inString.equalsIgnoreCase("y")) {
            beforeBattle();
        } else {
            System.out.println("Thanks for playing!");
            System.out.println("Final Score: " + players.get(0).getName() + " " + players.get(0).getWins() + " - " + players.get(1).getWins() + " " + players.get(1).getName());
            System.exit(0); // kill currect process
        }
    }

    public void beforeBattle() {
        resetBoard(); // reset gameboard to blanks
        turn = 0; // reset turn
        System.out.println("Battle started!");
        battle();
    }

    public void afterBattle() {
        printBoard();
        System.out.println("Score: " + players.get(0).getName() + " " + players.get(0).getWins() + " - " + players.get(1).getWins() + " " + players.get(1).getName());
        continyOrEnd();
    }

    public void printBoard() {
        String green = "\033[32m";
        String reset = "\033[0m";
        for (int i = 0; i < gameboard.length; i++) {
            if (i == 0) System.out.println("|-----------|");
            System.out.print("| " + //
                     // https://www.geeksforgeeks.org/java/how-to-print-colored-text-in-java-console/
                    // https://stackoverflow.com/questions/19599880/if-statement-inside-the-print-statement#19599898 fix all my problems
                    //  ? (if) : (else)
                    (gameboard[i][0] != ' ' ? green + gameboard[i][0] + reset : gameboard[i][0]) +
                    " | " +
                    (gameboard[i][1] != ' ' ? green + gameboard[i][1] + reset : gameboard[i][1]) +
                    " | " +
                    (gameboard[i][2] != ' ' ? green + gameboard[i][2] + reset : gameboard[i][2]) +
                    " |" + "\n");
            if (i < 2) System.out.println("|---+---+---|");
            if (i == 2) System.out.println("|-----------|");
        }
    }
}
