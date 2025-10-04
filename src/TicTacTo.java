import java.util.ArrayList;
import java.util.List;

public class TicTacTo {
    public List<Data> dataList = new ArrayList<>();
    //    Scanner sc = new Scanner(System.in);
    Output output = new Output(dataList);

    public List<Data> dataList() {
        if (dataList.isEmpty()) {
            dataList.add(new Data("player1", "X", 0, 0));
            dataList.add(new Data("player2", "O", 0, 0));
            dataList.add(new Data("AI", "O", 0, 0));
        }
        return dataList;
    }

    public void start() {
        System.out.println("hi");
        dataList();
        output.printIntro();
//        startUp();
//        Game Game = new Game();
//        Game.play();

    }

    public TicTacTo() {
        this.dataList = dataList;
    }
}

