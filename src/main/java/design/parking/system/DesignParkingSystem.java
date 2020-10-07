package design.parking.system;

/**
 * @author hum
 */
public class DesignParkingSystem {
    int[] tmp = new int[4];

    public DesignParkingSystem(int big, int medium, int small) {
        tmp[1] = big;
        tmp[2] = medium;
        tmp[3] = small;
    }

    public boolean addCar(int carType) {
        return tmp[carType]-- > 0;
    }
}
