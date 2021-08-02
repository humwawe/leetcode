package minimum.garden.perimeter.to.collect.enough.apples;

/**
 * @author hum
 */
public class MinimumGardenPerimeterToCollectEnoughApples {
    public long minimumPerimeter(long neededApples) {
        long n = 1;
        while (2 * n * (n + 1) * (2 * n + 1) < neededApples) {
            ++n;
        }
        return n * 8;
    }
}
