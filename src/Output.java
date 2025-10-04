import java.util.List;
import java.util.Scanner;

public class Output {
    Scanner sc = new Scanner(System.in);
    private List<Data> dataList;

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
                printPlayer1();
                printPlayer2();
            } else if (mode == 2) {
                System.out.println("1vAI mode selected");
                //TODO - Select difficulty
                System.out.println("Select difficulty: 1 - Easy, 2 - Medium,");
            } else { // Need this for 21
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

    public void printPlayer1() {
        System.out.println("Player 1 Name: leave blank for default");
        String name = sc.nextLine();
        name = sc.nextLine(); // eats the above code
        if (name.isBlank()) {
            System.out.println("Player 1 name set to default");
            dataList.get(0).setName("player1");
        } else {
            dataList.get(0).setName(name);
            System.out.println("Player 1 name set to " + dataList.get(0).getName());
        }
        System.out.print("Witch character do you want to be? X or O: ");
        String character = sc.nextLine().toUpperCase();
        if (character.equals("X") || character.equals("O")) {
            dataList.get(0).setCharacter(character);
            if (character.equals("X")) {
                dataList.get(1).setCharacter("O");
            } else {
                dataList.get(1).setCharacter("X");
            }
        } else {
            System.out.println("Invalid character selected, defaulting to X");
            dataList.get(0).setCharacter("X");
            dataList.get(1).setCharacter("O");
        }
    }

    public void printPlayer2() {
        System.out.println("Player 2 Name: leave blank for default");
        String name2 = sc.nextLine();
        if (name2.isBlank()) {
            System.out.println("Player 2 name set to default");
            dataList.get(1).setName("player2");
        } else {
            dataList.get(1).setName(name2);
            System.out.println("Player 2 name set to " + dataList.get(1).getName());
        }
        System.out.println("Player 1 is " + dataList.get(0).getName() + " and Player 2 is " + dataList.get(1).getName());


    }

}
