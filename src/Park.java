import java.util.List;

public class Park {

    public static void main(String[] args) {
        List<Animal> animals = List.of(
                new Shark("Sharky"),
                new BeardedVulture("Bone Eater"),
                new Cat("Whisky")
        );
        // REMINDER! Animal/sak i animals/list ge Animal animal ref
        for (Animal animal : animals) {
            animal.makeSound();
            animal.eat();
            if (animal instanceof BeardedVulture beardedVulture) {
                beardedVulture.awesome();
            }
            if (animal instanceof Swimmable swimmable) {
                swimmable.swim();
            }
            if (animal instanceof Flyable flyable) {
                flyable.fly();
            }
            System.out.println();
        }
    }

}
