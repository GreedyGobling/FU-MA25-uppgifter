public interface Swimmable {
    public default void swim() {
        System.out.println("this animal can swim");
    }
}
