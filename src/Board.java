public class Board {
    char[][] gameboard = new char[3][3];
    public void start() {
        System.out.println(gameboard);
        printBoard();
    }
    public void printBoard(){
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard.length; j++) {
                System.out.println(gameboard);
            }
        }
    }
}
