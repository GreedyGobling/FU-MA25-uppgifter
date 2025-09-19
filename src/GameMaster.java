import java.util.Scanner;

class GameMaster {
    Scanner sc = new Scanner(System.in);
    int round = 1;
    int turn = 1;
    int battleCount = 0;

    public void gameLoop(){
        if (battleCount < 1){
            battleCount++;
            selectEnemy();
        } else {
            System.out.println(Main.initCharacter().get(0).getHp() );
            Main.initCharacter().get(0).resetHp();
            selectEnemy();
        }

    }

    public void startCombat(Stats player, Stats enemy){
        System.out.println("Combat Started!");
        while(player.getHp() > 0 && enemy.getHp() > 0){
            System.out.println("Round: " + round + " Turn: " + turn);
            if(turn % 2 != 0){
                System.out.println("Player's turn!");
                Battle.Attack(player, enemy);
            } else {
                System.out.println("Enemy's turn!");
                Battle.Attack(enemy, player);
            }
            turn++;
            if(turn > 2){
                turn = 1;
                round++;
            }
        }
        if(player.getHp() <= 0){
            System.out.println();
            System.out.println("Player defeated!");
        } else {
            System.out.println();
            System.out.println("Enemy defeated!");
            gameLoop();
            enemy.resetHp();
        }

    }
    public void selectEnemy() {
        System.out.println("Select an enemdy to fight:");
        for (int i = 0; i < Main.initCharacter().size(); i++) {
            if (i == 0) continue;
            System.out.println(i + ": Enemy " + Main.initCharacter().get(i).getName());
        }
        System.out.println("Enter the number of the enemy you want to fight:");
        int choice = sc.nextInt();
        Stats enemy = Main.initCharacter().get(choice);
        System.out.println("Enemy " + enemy.getName() + " selected!");
        startCombat(Main.initCharacter().get(0), enemy);

    }
}
