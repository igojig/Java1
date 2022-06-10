package lesson7.factory;

import lesson7.Cat;
import lesson7.Plate;

import java.util.concurrent.ThreadLocalRandom;

public class PlateFactory {
    static Plate getInstance(){
        return new Plate(ThreadLocalRandom.current().nextInt(5, 20));
    }

    public static Plate[] getPlatesArray(int count){
        Plate[] plates=new Plate[count];
        for (int i= 0; i < count; i++) {
            plates[i]=getInstance();
        }
        return plates;
    }

}
