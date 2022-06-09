package lesson6.animal_1;

public class Dog extends Animal {
    private static final int RUN_LIMIT_LENGTH = 500;
    private static final int SWIM_LIMIT_LENGTH = 10;

    private static int dogCount;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int length) {
        if (length >= RUN_LIMIT_LENGTH) {
            System.out.println(getAnimalName() + " не может пробежать " + length + " метров. Может только " + RUN_LIMIT_LENGTH);
        } else {
            System.out.println(getAnimalName() + " пробежала " + length + " метров. Предел - " + RUN_LIMIT_LENGTH + " метров");
        }
    }

    @Override
    public void swim(int length) {
        if (length >= SWIM_LIMIT_LENGTH) {
            System.out.println(getAnimalName() + " не может проплыть " + length + " метров. Может только " + SWIM_LIMIT_LENGTH);
        } else {
            System.out.println(getAnimalName() + " проплыла " + length + " метров. Предел - " + SWIM_LIMIT_LENGTH + " метров");
        }
    }

    @Override
    public String getAnimalName() {
        return "Собака " + getName();
    }

    public static int getDogCount() {
        return dogCount;
    }
}
