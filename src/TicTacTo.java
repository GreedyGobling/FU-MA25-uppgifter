import java.util.Scanner;

public class TicTacTo {
    Scanner sc = new Scanner(System.in);

    public void start() {
        startUp();
//        Game Game = new Game();
//        Game.play();

    }

    private void startUp() {
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("1 - 1v1, 2 - 1vAI");
        System.out.println("Choose your mode: ");
        try {
            int mode = sc.nextInt();
            if (mode == 1) {
                System.out.println("1v1 mode selected");
            } else if (mode == 2) {
                System.out.println("1vAI mode selected");
            } else {
                System.out.println("Invalid mode selected");
                sc.nextLine();
                startUp();
            }
        }catch(Exception e){
                System.out.println("Invalid mode selected");
                sc.nextLine();
                startUp();
            }
        }
    }

