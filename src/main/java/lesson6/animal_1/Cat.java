package lesson6.animal_1;


public class Cat extends Animal {
    private static final int RUN_LIMIT_LENGTH = 200;

    private static int catCount;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    public void run(int length) {
        if (length >= RUN_LIMIT_LENGTH) {
            System.out.println(getAnimalName() + " не может пробежать " + length + " метров. Может только " + RUN_LIMIT_LENGTH);
        } else {
            System.out.println(getAnimalName() + " пробежал " + length + " метров. Предел - " + RUN_LIMIT_LENGTH + " метров");
        }
    }

    @Override
    public void swim(int length) {
        System.out.println(getAnimalName() + " не умеет плавать");
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public String getAnimalName() {
        return "Кот " + getName();
    }
}
