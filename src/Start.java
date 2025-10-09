import java.util.ArrayList;
import java.util.List;

public class Start {
    public List<Player> players = new ArrayList<>();
    ManuUI manuUI = new ManuUI(players);
    GameBoard gameBoard = new GameBoard(players);

    public List<Player> initPlayers() {
        if (players.isEmpty()) {
            players.add(new Player("player1", "X", 0, 0));
        }
        return players;
    }

    public void start() {
        initPlayers();
        manuUI.printIntro();
        gameBoard.beforeBattle();
    }

}

