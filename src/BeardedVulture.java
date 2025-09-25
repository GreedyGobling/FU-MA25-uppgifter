public class BeardedVulture extends Animal implements Flyable {
    public BeardedVulture(String name) {
        super(name);
    }
    @Override
    public void makeSound() {
        System.out.println("Bearded Vulture (" + getName() + ") says: SCRREEEEE");
    }

    public void awesome() {
        System.out.println("Bearded Vulture (" + getName() + ") looks awesome (sök up bild)");
    }

    @Override
    public void eat() {
        System.out.println("Bearded Vulture (" + getName() + ") eats: bones. yes it true");
    }

}
