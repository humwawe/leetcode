package car.fleet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        if (len == 0) {
            return 0;
        }
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(new Car(position[i], (double) (target - position[i]) / speed[i]));
        }
        list.sort((a, b) -> b.pos - a.pos);

        double prev = list.get(0).time;
        int result = 1;
        for (int i = 1; i < len; i++) {
            if (list.get(i).time > prev) {
                result++;
                prev = list.get(i).time;
            }
        }
        return result;

    }

    class Car {
        int pos;
        double time;

        public Car(int pos, double time) {
            this.pos = pos;
            this.time = time;
        }
    }
}
