public class Data {
    public String name;
    public String character;
    public int difficulty;
    public int wins;


    public Data(String name, String character, int difficulty, int wins) {
        this.name = name;
        this.character = character;
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

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
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
