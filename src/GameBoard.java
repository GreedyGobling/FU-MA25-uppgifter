import java.util.List;

public class GameBoard {
    public final char[][] gameboard = new char[3][3]; // 2d array
    public List<Player> players;
    public int turn = 0;
    public boolean gameOver = false;

    public GameBoard(List<Player> players) {
        this.players = players;
    }

    public void makeMove(int input, int id) {
        int row = (input - 1) / 3; // get the row
        int col = (input - 1) % 3; // get the column
        char placeMarker = players.get(id).getSymbol().charAt(0); // get the character
        isDraw();
        if (input < 1 || input > 9) {
            System.out.println("Invalid input, please enter a number from 1 to 9");
        } else if (gameboard[row][col] != ' ') {
            System.out.println("Cell already occupied, please choose another cell");
        } else {
            gameboard[row][col] = placeMarker; // place the mark
        }
    }

    public void checkGame(int id) {
        if (checkWin(players.get(id).getSymbol().charAt(0))) {
            gameOver = true;
            System.out.println(players.get(id).getName() + " wins!");
            players.get(id).setWins(players.get(id).getWins() + 1);
//            afterBattle(); //TODO fix a alternativ  and 4 lines below // Not needed???
        } else if (isDraw()) {
            gameOver = true;
            System.out.println("Draw!");
//            continyOrEnd(); //TODO fix a alternativ  and 4 lines above
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

    public void resetBoard() {
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard.length; j++) {
                gameboard[i][j] = ' '; // fill the gameboard with empty spaces
            }
        }
    }

}
