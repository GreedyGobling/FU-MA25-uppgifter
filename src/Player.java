public class Player {
    public String name;
    public String symbol;
    public int difficulty;
    public int wins;


    public Player(String name, String symbol, int difficulty, int wins) {
        this.name = name;
        this.symbol = symbol;
        this.difficulty = difficulty;
        this.wins = wins;
    }

    // <editor-fold desc="Getters and Setters">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
    // </editor-fold>

}
