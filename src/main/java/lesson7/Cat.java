package lesson7;

import java.util.concurrent.ThreadLocalRandom;

public class Cat {

    // за раз кот может съесть от 1 до 10 единиц корма
    private static final int HUNGRY_LIMIT = 10;

    private final String name;
    private int appetite;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {

        System.out.print(this + " подошел к тарелке " + plate);

        // кот не может съесть больше, чем его текущий аппетит или лимит. Что меньше.
        int hungryAmount = ThreadLocalRandom.current().nextInt(1, Math.min(HUNGRY_LIMIT, appetite) + 1);
        System.out.println(" хочеть съесть " + hungryAmount + " корма");

        // проверяем что еды а тарелке достаточно
        if (plate.decreaseFoodCount(hungryAmount)) {
            appetite -= hungryAmount;
            System.out.println(this + " съел " + hungryAmount + " корма. " + getAppetiteStr());
            // иначе съедаем всю доступную еду
        } else {
            appetite -= plate.getFoodCount();
            System.out.println(this + " Мне не хватило еды. Я съел " + plate.getFoodCount() + " корма. " + getAppetiteStr());
            plate.decreaseAllFood();
        }

//        // проверяем что еды а тарелке достаточно
//        if (plate.isEnoughFood(hungryAmount)) {
//            plate.decreaseFoodCount(hungryAmount);
//            appetite -= hungryAmount;
//            System.out.println(this + " съел " + hungryAmount + " корма. " + getAppetiteStr());
//            // иначе съедаем всю доступную еду
//        } else {
//            appetite -= plate.getFoodCount();
//            System.out.println(this + " Мне не хватило еды. Я съел " + plate.getFoodCount() + " корма. " + getAppetiteStr());
//            plate.decreaseAllFood();
//        }
    }

    boolean isHungry() {
        return appetite > 0;
    }

    public String getAppetiteStr() {
        return appetite > 0 ? "Я еще хочу есть. Аппетит = " + appetite : "Я сыт и доволен";
    }

    @Override
    public String toString() {
        return "Кот{" +
                name +
                ", аппетит=" + appetite +
                '}';
    }

    public String getName() {
        return name;
    }
}
