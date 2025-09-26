public class BeardedVulture extends Animal implements Flyable, FunFact {
    public BeardedVulture(String name) {
        super(name);
    }

    @Override
    public void fact() {
        System.out.println("Bearded Vulture (" + getName() + ") looks awesome (search up a image)");
    }
    @Override
    public void makeSound() {
        System.out.println("Bearded Vulture (" + getName() + ") says: SCRREEEEE");
    }

    @Override
    public void fly() {
        System.out.println("Bearded Vulture (" + getName() + ") flies");
    }

    @Override
    public void eat() {
        System.out.println("Bearded Vulture (" + getName() + ") eats: bones and carrion (yes bones 70%)");
    }

}
