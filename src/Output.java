import java.util.List;
import java.util.Scanner;

public class Output {
    Scanner sc = new Scanner(System.in);
    private List<Data> dataList;
//    TicTacTo tic = new TicTacTo();

    public Output(List<Data> dataList) {
        this.dataList = dataList;
    }

    public void printIntro() {
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("1 - 1v1, 2 - 1vAI");
        System.out.println("Choose your mode: ");

        try {
            int mode = sc.nextInt();
            if (mode == 1) {
                System.out.println("1v1 mode selected");
                System.out.println("Player 1 Name:  : leave blank for default");
                String name = sc.nextLine();
                name = sc.nextLine();
                if (name.isBlank()) {
                    System.out.println("Player 1 name set to default");
                    dataList.get(0).setName("player1");
//                    dataList().get(0).setName("player1");
                } else {
                    dataList.get(0).setName(name);
                    System.out.println("Player 1 name set to " + dataList.get(0).getName());

//                    dataList().get(0).setName(name);
//                    System.out.println("Player 1 name set to " + dataList().get(0).getName());
                }

            } else if (mode == 2) {
                System.out.println("1vAI mode selected");
                //TODO - Select difficulty
                System.out.println("Select difficulty: 1 - Easy, 2 - Medium,");
            } else {
                System.out.println("Invalid mode selected");
                sc.nextLine();
                printIntro();
            }
        } catch (Exception e) {
            System.out.println("Invalid mode selected");
            sc.nextLine();
            printIntro();
        }
    }
}
