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
        System.out.println("Bearded Vulture (" + getName() + ") is flying high in the sky with a wingspan of up to 2.8 meters.");
    }

    @Override
    public void eat() {
        System.out.println("Bearded Vulture (" + getName() + ") eats: bones. yes it true");
    }

}
