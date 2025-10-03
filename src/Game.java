import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    Board board = new Board();

    public void play() {
        System.out.println("Game started!");
        board.print();
        int choice = sc.nextInt();
        System.out.println("You chose: " + choice);


    }
}
