public class Stats {
    private int hp;
    private int baseHp;
    private int minAttack;
    private int maxAttack;
    private int defense;

    public Stats(int hp, int baseHp, int minAttack, int maxAttack, int defense) {
        this.hp = hp;
        this.baseHp = baseHp;
        this.minAttack = minAttack;
        this.maxAttack = maxAttack;
        this.defense = defense;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getBaseHp() {
        return baseHp;
    }

    public void setBaseHp(int baseHp) {
        this.baseHp = baseHp;
    }

    public int getMinAttack() {
        return minAttack;
    }

    public void setMinAttack(int minAttack) {
        this.minAttack = minAttack;
    }

    public int getMaxAttack() {
        return maxAttack;
    }

    public void setMaxAttack(int maxAttack) {
        this.maxAttack = maxAttack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void reset(){
        this.hp = this.baseHp;
    }
}
