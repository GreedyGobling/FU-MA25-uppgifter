public class Battle {
    public static void Attack(Stats attacker, Stats defender){
        int damage = (int)(Math.random() * (attacker.getMaxAttack() - attacker.getMinAttack() + 1)) + attacker.getMinAttack();
//        damage -= defender.getDefense();
        if (defender.getDefense() > damage) damage = 0; // AC from dnd
        if(damage < 0) damage = 0;
        defender.setHp(defender.getHp() - damage);
        if(defender.getHp() < 0) defender.setHp(0);
        System.out.println("Damage dealt: " + damage + ", Defender HP: " + defender.getHp());
    }
}
