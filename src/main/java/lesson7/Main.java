package lesson7;

import lesson7.factory.CatFactory;
import lesson7.factory.PlateFactory;

public class Main {

    public static void main(String[] args) {

        final int CAT_COUNT=2;
        final int PLATE_COUNT=2;


//        Cat cat1 = new Cat("cat1", 15);
//        Cat cat2 = new Cat("cat2", 20);
//        Cat cat3 = new Cat("cat3", 10);
//        Cat cat4 = new Cat("cat4", 10);
//
//        Plate plate1 = new Plate(20);
//        Plate plate2 = new Plate(10);
//        Plate plate3 = new Plate(5);
//        Plate plate4 = new Plate(5);
//        Plate plate5 = new Plate(5);

        // заполняем наши массивы
//        FeedingCats.setCats(cat1, cat2, cat3, cat4);
//        FeedingCats.setPlates(plate1, plate2, plate3, plate4, plate5);

        FeedingCats.setCats(CatFactory.getCatsArray(CAT_COUNT));
        FeedingCats.setPlates(PlateFactory.getPlatesArray(PLATE_COUNT));

        FeedingCats.showCatsInfo();
        FeedingCats.showPlatesInfo();

        FeedingCats.feedAllCatsFromAllPlates();
        FeedingCats.showCatsInfo();
        FeedingCats.showPlatesInfo();

    }
}
