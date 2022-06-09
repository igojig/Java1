package lesson6.animal_1;

abstract public class Animal {

    private static int animalCount;

    private final String name;

    abstract public void run(int length);

    abstract public void swim(int length);

    public abstract String getAnimalName();

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public String getName() {
        return name;
    }
}
