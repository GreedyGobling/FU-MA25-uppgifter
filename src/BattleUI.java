import java.util.List;
import java.util.Scanner;

public class BattleUI {
    Scanner sc = new Scanner(System.in);
    private GameBoard gameBoard;

    public void BattleUI(List<Player> players) {
        this.gameBoard = new GameBoard(players);
    }

    public void battle() {
        try {
            for (gameBoard.gameOver = false; !gameBoard.gameOver; ) {
                if (gameBoard.turn == 0) {
                    players(0);
                    gameBoard.turn++;
                } else {
                    if (gameBoard.players.get(1).getName().equals("AI925")) {
                        gameBoard.randomBot(1);
                    } else {
                        players(1);
                    }
                    gameBoard.turn--;
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input, please enter a number from 1 to 9");
            sc.nextLine();
            battle();
        }
        afterBattle();
    }

    public void beforeBattle() {
        gameBoard.resetBoard();
        System.out.println("Get ready for battle!");
        battle();
    }

    public void afterBattle() {
        printBoard();
        System.out.println("Score: " + gameBoard.players.get(0).getName() + " " + gameBoard.players.get(0).getWins() + " - " + gameBoard.players.get(1).getWins() + " " + gameBoard.players.get(1).getName());
        continyOrEnd();
    }

    public void continyOrEnd() {
        System.out.println("Continue? (y/n)");
        String inString = sc.nextLine();
        if (inString.equalsIgnoreCase("y")) {
            beforeBattle();
        } else {
            System.out.println("Thanks for playing!");
            System.out.println("Final Score: " + gameBoard.players.get(0).getName() + " " + gameBoard.players.get(0).getWins() + " - " + gameBoard.players.get(1).getWins() + " " + gameBoard.players.get(1).getName());
            System.exit(0); // kill currect process
        }
    }

    public void players(int id) {
        printBoard();
        System.out.println(gameBoard.players.get(id).getName() + " Turn");
        System.out.println("“Choose a tile by entering a number from 1 to 9");
        int input = sc.nextInt();
        sc.nextLine();
        gameBoard.makeMove(input, id);
        gameBoard.checkGame(id);
    }

    public void printBoard() {
        String green = "\033[32m";
        String reset = "\033[0m";
        for (int i = 0; i < gameBoard.gameboard.length; i++) {
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
