import java.util.List;
import java.util.Scanner;

public class ManuUI {
    Scanner sc = new Scanner(System.in);
    private List<Player> players;

    public ManuUI(List<Player> players) {
        this.players = players;
    }

    public void printIntro() {
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("1 - 1v1, 2 - 1vAI");
        System.out.println("Choose your mode: ");
        try {
            int mode = sc.nextInt();
            if (mode == 1) {
                players.add(new Player("player2", "O", 0, 0));
                System.out.println("1v1 mode selected");
                printPlayer1();
                printPlayer2();
                printBattle(players.get(1).getDifficulty());
            } else if (mode == 2) {
                players.add(new Player("AI925", "O", 0, 0));
                printPlayer1();
                System.out.println("1vAI mode selected");
                printAI();
                printBattle(players.get(1).getDifficulty());

            } else { // Need this for 21
                System.out.println("Invalid mode selected");
                sc.nextLine();
                printIntro();

            }
        } catch (Exception e) {
            System.out.println("Invalid mode selected");
            System.out.println("Return to main menu");
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
            players.get(0).setName("player1");
        } else {
            players.get(0).setName(name);
            System.out.println("Player 1 name set to " + players.get(0).getName());
        }
        System.out.print("Witch symbol do you want to be? X or O: ");
        String symbol = sc.nextLine().toUpperCase();
        if (symbol.equals("X") || symbol.equals("O")) {
            players.get(0).setSymbol(symbol);
            if (symbol.equals("X")) {
                players.get(1).setSymbol("O");
            } else {
                players.get(1).setSymbol("X");
            }
        } else {
            System.out.println("Invalid symbol selected, defaulting to X");
            players.get(0).setSymbol("X");
            players.get(1).setSymbol("O");
        }
    }

    public void printPlayer2() {
        System.out.println("Player 2 Name: leave blank for default");
        String name2 = sc.nextLine();
        if (name2.isBlank()) {
            System.out.println("Player 2 name set to default");
            players.get(1).setName("player2");
        } else {
            players.get(1).setName(name2);
            System.out.println("Player 2 name set to " + players.get(1).getName());
        }
        System.out.println("Player 1 is " + players.get(0).getName() + " and Player 2 is " + players.get(1).getName());
    }

    public void printAI() {
//        System.out.println("Select difficulty: 1 - Random, 2 - :) ");
//        int dif = sc.nextInt();
//        if (dif == 1) {
//            dataList.get(1).setDifficulty(1);
//            System.out.println("Random difficulty selected");
//        } else if (dif == 2) {
//            dataList.get(1).setDifficulty(2);
//            System.out.println(" :) difficulty selected");
//        } else {
//            System.out.println("Invalid difficulty selected, defaulting to Random");
//            dataList.get(1).setDifficulty(1);
//        }
    }

    public void printBattle(int g) {
        System.out.println("Battle starting!");
        if (g == 0) { // 1v1
            System.out.println("Player 1 is " + players.get(0).getName() + " and Player 2 is " + players.get(1).getName());
        } else if (g == 1 || g == 2) { // 1vAI
            System.out.println("Player is " + players.get(0).getName() + " vs AI");
            System.out.println("AI difficulty is " + (g == 1 ? "Random" : ":)"));
        }
    }
}
