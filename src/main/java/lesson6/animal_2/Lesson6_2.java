package lesson6.animal_2;

import lesson6.animal_2.interfaces.IRun;
import lesson6.animal_2.interfaces.ISwim;

import java.util.concurrent.ThreadLocalRandom;

public class Lesson6_2 {
    public static void main(String[] args) {

        final int RUN_LIMIT_LENGTH = 600;
        final int SWIM_LIMIT_LENGTH = 20;

        System.out.println("Котов создано: " + Cat.getCatCount());
        System.out.println("Собак создано: " + Dog.getDogCount());
        System.out.println("Всего животных создано: " + Animal.getAnimalCount());

        System.out.println();

        Cat cat1 = new Cat("cat1");
        Cat cat2 = new Cat("cat2");
        Cat cat3 = new Cat("cat3");
        Cat cat4 = new Cat("cat4");

        Dog dog1 = new Dog("dog1");
        Dog dog2 = new Dog("dog2");
        Dog dog3 = new Dog("dog3");

        IRun[] animalsCanRun = {cat1, dog1, cat2, dog2, cat3, dog3, cat4};
        ISwim[] animalsCanSwim = {dog1, dog2, dog3};

        doRun(RUN_LIMIT_LENGTH, animalsCanRun);
        doSwim(SWIM_LIMIT_LENGTH, animalsCanSwim);

        System.out.println();

        System.out.println("Котов создано: " + Cat.getCatCount());
        System.out.println("Собак создано: " + Dog.getDogCount());
        System.out.println("Всего животных создано: " + Animal.getAnimalCount());
    }

    private static void doSwim(int limit, ISwim[] animalsCanSwim) {
        for (ISwim iSwim : animalsCanSwim) {
            int swimLength = ThreadLocalRandom.current().nextInt(1, limit);
            iSwim.swim(swimLength);
        }
    }

    private static void doRun(int limit, IRun[] animalsCanRun) {
        for (IRun iRun : animalsCanRun) {
            int runLength = ThreadLocalRandom.current().nextInt(1, limit);
            iRun.run(runLength);
        }
    }

}
