package lesson6.animal_2;

abstract public class Animal {

    private static int animalCount;

    private final String name;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public abstract String getAnimalName();

    public static int getAnimalCount() {
        return animalCount;
    }

    public String getName() {
        return name;
    }
}
