package water.and.jug.problem;

import java.util.*;

/**
 * @author hum
 */
public class WaterAndJugProblem {

    public boolean canMeasureWater2(int x, int y, int z) {
        return z == 0 || (x + y >= z && z % gcd(x, y) == 0);
    }

    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    public boolean canMeasureWater(int x, int y, int z) {
        Queue<Bucket> queue = new ArrayDeque<>();
        queue.add(new Bucket(0, 0));
        Set<Bucket> set = new HashSet<>();

        while (!queue.isEmpty()) {
            Bucket poll = queue.poll();
            int b1 = poll.bucket1;
            int b2 = poll.bucket2;
            Bucket bucket1 = new Bucket(b1, b2);
            bucket1.bucket1 = x;
            if (check(bucket1, z)) {
                return true;
            }
            if (!set.contains(bucket1)) {
                set.add(bucket1);
                queue.add(bucket1);
            }
            Bucket bucket2 = new Bucket(b1, b2);
            bucket2.bucket2 = y;
            if (check(bucket2, z)) {
                return true;
            }
            if (!set.contains(bucket2)) {
                set.add(bucket2);
                queue.add(bucket2);
            }
            Bucket bucket3 = new Bucket(b1, b2);
            bucket3.bucket1 = 0;
            if (check(bucket3, z)) {
                return true;
            }
            if (!set.contains(bucket3)) {
                set.add(bucket3);
                queue.add(bucket3);
            }
            Bucket bucket4 = new Bucket(b1, b2);
            bucket4.bucket2 = 0;
            if (check(bucket4, z)) {
                return true;
            }
            if (!set.contains(bucket4)) {
                set.add(bucket4);
                queue.add(bucket4);
            }

            Bucket bucket5 = new Bucket(b1, b2);
            bucket5.bucket1 = Math.min(x, b1 + b2);
            bucket5.bucket2 = Math.max(0, b2 - (x - b1));
            if (check(bucket5, z)) {
                return true;
            }
            if (!set.contains(bucket5)) {
                set.add(bucket5);
                queue.add(bucket5);
            }

            Bucket bucket6 = new Bucket(b1, b2);
            bucket6.bucket2 = Math.min(y, b2 + b1);
            bucket6.bucket1 = Math.max(0, b1 - (y - b2));
            if (check(bucket6, z)) {
                return true;
            }
            if (!set.contains(bucket6)) {
                set.add(bucket6);
                queue.add(bucket6);
            }
        }
        return false;

    }

    private boolean check(Bucket bucket, int z) {
        return bucket.bucket1 == z || bucket.bucket2 == z || bucket.bucket1 + bucket.bucket2 == z || Math.abs(bucket.bucket1 - bucket.bucket2) == z;
    }

    class Bucket {
        private int bucket1;
        private int bucket2;

        public Bucket(int bucket1, int bucket2) {
            this.bucket1 = bucket1;
            this.bucket2 = bucket2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Bucket bucket = (Bucket) o;
            return bucket1 == bucket.bucket1 &&
                    bucket2 == bucket.bucket2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(bucket1, bucket2);
        }
    }
}
