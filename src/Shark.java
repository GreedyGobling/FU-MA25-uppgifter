public class Shark extends Animal implements Swimmable {
    public Shark(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Shark (" + getName() + ") says: Dun Dun... Dun Dun... Dun Dun...");
    }

    @Override
    public void eat() {
        System.out.println("Shark (" + getName() + ") eats: fish and seals");
    }

}
