import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        initCharacter();
        GameMaster gm = new GameMaster();
        gm.gameLoop();
    }

    public static List<Stats> initCharacter() {
        Stats go = new Stats("player", 10, 10, 1, 4, 2, 1, 0);
        Stats go1 = new Stats("orc", 5, 5, 1, 3, 1, 1, 0);
        Stats go2 = new Stats("troll",10, 10, 0, 3, 2, 1, 0);
        Stats go3 = new Stats("skeleton",3, 3, 0, 2, 0, 1, 0);

        List<Stats> statsList = new ArrayList<>();
        statsList.add(go);
        statsList.add(go1);
        statsList.add(go2);
        statsList.add(go3);
        return statsList;
    }

}
