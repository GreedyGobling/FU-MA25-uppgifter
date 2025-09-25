public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Cat (" + getName() + ") says: Meow");
    }

    @Override
    public void eat() {
        System.out.println("Cat (" + getName() + ") eats: fish and meat");
    }
}
