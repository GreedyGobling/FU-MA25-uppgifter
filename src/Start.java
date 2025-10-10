import java.util.ArrayList;
import java.util.List;

public class Start {
    public List<Player> players = new ArrayList<>();
    ManuUI manuUI = new ManuUI(players);
    GameBoard gameBoard = new GameBoard(players);
    BattleUI battleUI = new BattleUI(players);

    public List<Player> initPlayers() {
        if (players.isEmpty()) {
            players.add(new Player("player1", "X", 0, 0));
        }
        return players;
    }

    public void start() {
        initPlayers();
//        battleUI.printBoard();
        manuUI.printIntro();
        battleUI.beforeBattle();
    }

}

