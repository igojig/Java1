package lesson7.factory;

import lesson7.Cat;

import java.util.concurrent.ThreadLocalRandom;

public class CatFactory {
    static int id;

    static Cat getInstance(){
        return new Cat("cat_"+ ++id, ThreadLocalRandom.current().nextInt(10, 30));
    }

    public static Cat[] getCatsArray(int count){
        Cat[] cats=new Cat[count];
        for (int i= 0; i < count; i++) {
            cats[i]=getInstance();
        }
        return cats;
    }
}

