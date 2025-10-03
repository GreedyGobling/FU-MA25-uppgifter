public class Data {
    public String name;
    public String character;
    public int difficulty;

    public Data(String name, String character, int difficulty) {
        this.name = name;
        this.character = character;
        this.difficulty = difficulty;
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
    // </editor-fold>

}
