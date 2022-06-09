package lesson7;

public class FeedingCats {

    private static Cat[] cats;
    private static Plate[] plates;

    public static void setCats(Cat... cats) {
        FeedingCats.cats = cats;
    }

    public static void setPlates(Plate... plates) {
        FeedingCats.plates = plates;
    }

    public static void feedAllCatsFromAllPlates() {
        if (cats == null || plates == null) {
            return;
        }

        int j = 0;

        CAT:
        for (Cat cat : cats) {
            PLATE:
            // не едим снова из пустых тарелок
            // и если тарелка не закончилась следющий кот продолжает есть из текущй тарелки
            for (; j < plates.length; j++) {
                while (true) {
                    if (!cat.isHungry()) {
                        continue CAT;
                    }
                    if (plates[j].isEmpty()) {
                        continue PLATE;
                    }
                    cat.eat(plates[j]);
                    System.out.println();
                }
            }
        }
    }

    public static void showCatsInfo() {
        for (Cat cat : cats) {
            System.out.println("Кот " + cat.getName() + " " + cat.getAppetiteStr());
        }
    }

    public static void showPlatesInfo() {
        for (Plate plate : plates) {
            System.out.println("Тарелка " + plate.getId() + " содержит " + plate.getFoodCount() + " корма");
        }
    }
}
