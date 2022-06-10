package lesson7;

public class Plate {
    private static int count;
    final private int id;
    private int foodCount;

    public Plate(int foodCount) {
        this.foodCount = foodCount;
        id = ++count;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public boolean isEmpty() {
        return foodCount <= 0;
    }

    // true - если еды в тарелке достаточно
    // false - если еды в тарелке меньше, чем хотим съесть
    public boolean decreaseFoodCount(int amount) {
        if (amount > foodCount) {
            return false;
        }
        foodCount -= amount;
        System.out.println("Из тарелки " + id + " съели " + amount + " корма. " + printRemainFood());
        return true;
    }

    public void decreaseAllFood() {
        decreaseFoodCount(foodCount);
    }

    public boolean isEnoughFood(int foodAmount) {
        return foodAmount <= foodCount;
    }

    public String printRemainFood() {
        return ("Осталось корма: " + foodCount);
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Тарелка {" +
                "id=" + id +
                ", корма=" + foodCount +
                '}';
    }

}
