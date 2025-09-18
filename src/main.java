import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        initializeGame();
        battle();
        System.out.println("Hello, World!");
    }

    private static void initializeGame(){
        Stats Player = new Stats(10, 10, 1, 5, 1, 1);
        Stats Orc = new Stats(6, 6, 1, 3, 0, 1);
        Stats Troll = new Stats(15, 15, 0, 3, 2, 1);

        //TODO fix this list / arraylist shit
        List<Stats> enemies = new ArrayList<>();
        enemies.add(Orc);
        enemies.add(Troll);

    }

    private static void battle(Stats player, Stats enemy){
        boolean playerTurn = true;
        if (playerTurn){
            playerTurn = false;
            Attack(player, enemy);
        }else {
            Attack(enemy, player);
            playerTurn = true;
        }
    }

    private static void Attack(Stats attacker, Stats defender){
        int damage = (int)(Math.random() * (attacker.getMaxAttack() - attacker.getMinAttack() + 1)) + attacker.getMinAttack();
        damage -= defender.getDefense();
        if(damage < 0) damage = 0;
        defender.setHp(defender.getHp() - damage);
        if(defender.getHp() < 0) defender.setHp(0);
        System.out.println("Damage dealt: " + damage + ", Defender HP: " + defender.getHp());
    }

}
