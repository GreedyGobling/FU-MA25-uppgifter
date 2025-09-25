public abstract class Animal {
    String name;

    public abstract void makeSound();{

    }

    public abstract void eat();{

    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
