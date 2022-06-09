package lesson6.animal_1;


import java.util.concurrent.ThreadLocalRandom;

public class Lesson6_1 {
    public static void main(String[] args) {
        
        final int RUN_LIMIT_LENGTH = 600;
        final int SWIM_LIMIT_LENGTH = 20;

        System.out.println("Котов создано: " + Cat.getCatCount());
        System.out.println("Собак создано: " + Dog.getDogCount());
        System.out.println("Всего животных создано: " + Animal.getAnimalCount());

        System.out.println();

        Animal cat1 = new Cat("cat1");
        Animal cat2 = new Cat("cat2");
        Animal cat3 = new Cat("cat3");
        Animal cat4 = new Cat("cat4");

        Animal dog1 = new Dog("dog1");
        Animal dog2 = new Dog("dog2");
        Animal dog3 = new Dog("dog3");

        Animal[] animals = {cat1, dog1, cat2, dog2, cat3, dog3, cat4};

        for (Animal animal : animals) {
            int swimLength = ThreadLocalRandom.current().nextInt(1, SWIM_LIMIT_LENGTH);
            int runLength = ThreadLocalRandom.current().nextInt(1, RUN_LIMIT_LENGTH);
            animal.run(runLength);
            animal.swim(swimLength);
        }

        System.out.println();

        System.out.println("Котов создано: " + Cat.getCatCount());
        System.out.println("Собак создано: " + Dog.getDogCount());
        System.out.println("Всего животных создано: " + Animal.getAnimalCount());
    }
}
