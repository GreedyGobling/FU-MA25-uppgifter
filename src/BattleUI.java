import java.util.List;
import java.util.Scanner;

public class BattleUI {
    Scanner sc = new Scanner(System.in);
    private List<Player> players;
    private GameBoard gameBoard;

    public BattleUI(List<Player> players) {
        this.players = players;
        this.gameBoard = new GameBoard(players);
    }

    public void printBoard() {
        String green = "\033[32m";
        String reset = "\033[0m";
        for (int i = 0; i <  gameBoard.gameboard.length; i++) {
            if (i == 0) System.out.println("|-----------|");
            System.out.print("| " +
                    (gameBoard.gameboard[i][0] != ' ' ? green + gameBoard.gameboard[i][0] + reset : gameBoard.gameboard[i][0]) +
                    " | " +
                    (gameBoard.gameboard[i][1] != ' ' ? green + gameBoard.gameboard[i][1] + reset : gameBoard.gameboard[i][1]) +
                    " | " +
                    (gameBoard.gameboard[i][2] != ' ' ? green + gameBoard.gameboard[i][2] + reset : gameBoard.gameboard[i][2]) +
                    " |" + "\n");
            if (i < 2) System.out.println("|---+---+---|");
            if (i == 2) System.out.println("|-----------|");
        }
    }
}
