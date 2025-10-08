import java.util.ArrayList;
import java.util.List;

public class Start {
    public List<Player> players = new ArrayList<>();
    ManuUI manuUI = new ManuUI(players);
    Board board = new Board(players);

    public List<Player> players() {
        if (players.isEmpty()) {
            players.add(new Player("player1", "X", 0, 0));
//            dataList.add(new Data("player2", "O", 0, 0)); // old method
//            dataList.add(new Data("AI", "O", 0, 0)); // old method
        }
        return players;
    }

    public void start() {
        players();
        manuUI.printIntro();
        board.beforeBattle();
    }

}

