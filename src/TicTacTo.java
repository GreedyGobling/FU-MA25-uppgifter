import java.util.ArrayList;
import java.util.List;

public class TicTacTo {
    public List<Data> dataList = new ArrayList<>();
    //    Scanner sc = new Scanner(System.in);
    Output output = new Output(dataList);



    public List<Data> dataList() {
        if (dataList.isEmpty()) {
            dataList.add(new Data("player1", "X", 0));
            dataList.add(new Data("player2", "O", 0));
            dataList.add(new Data("AI", "O", 0));
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

    private void startUp() {
        output.printIntro();
//        System.out.println("Welcome to Tic Tac Toe!");
//        System.out.println("1 - 1v1, 2 - 1vAI");
//        System.out.println("Choose your mode: ");
//        try {
//            int mode = sc.nextInt();
//            if (mode == 1) {
//                System.out.println("1v1 mode selected");
//                System.out.println("Player 1 Name:  : leave blank for default");
//                String name = sc.nextLine();
//                name = sc.nextLine();
//                if (name.isBlank()) {
//                    System.out.println("Player 1 name set to default");
//                    dataList().get(0).setName("player1");
//                } else {
//                    dataList().get(0).setName(name);
//                    System.out.println("Player 1 name set to " + dataList().get(0).getName());
//                }
//
//            } else if (mode == 2) {
//                System.out.println("1vAI mode selected");
//                //TODO - Select difficulty
//                System.out.println("Select difficulty: 1 - Easy, 2 - Medium,");
//            } else {
//                System.out.println("Invalid mode selected");
//                sc.nextLine();
//                startUp();
//            }
//        } catch (Exception e) {
//            System.out.println("Invalid mode selected");
//            sc.nextLine();
//            startUp();
//        }
    }

//    public static List<Data> dataList(){
//        List<Data> dataList =  new ArrayList<>();
//        dataList.add(new Data("player1", "X", 0));
//        dataList.add(new Data("player2", "O", 0));
//        dataList.add(new Data("AI", "O", 0));
//        return dataList;
//    }
}

