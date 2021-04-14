package finding.mk.average;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class FindingMkAverage {
    long sum = 0;
    PriorityQueue<Integer> min = new PriorityQueue<>((x, y) -> y - x);
    PriorityQueue<Integer> max = new PriorityQueue<>();
    PriorityQueue<Integer> mid1 = new PriorityQueue<>();
    PriorityQueue<Integer> mid2 = new PriorityQueue<>((x, y) -> y - x);
    int m;
    int k;
    List<Integer> list = new ArrayList<>();

    public FindingMkAverage(int m, int k) {
        this.m = m;
        this.k = k;
    }

    public void addElement(int num) {
        list.add(num);
        if (!min.isEmpty() && min.peek() >= num) {
            min.add(num);
        } else if (!max.isEmpty() && max.peek() <= num) {
            max.add(num);
        } else {
            mid1.add(num);
            mid2.add(num);
            sum += num;
        }

        if (min.size() > k) {
            int cur = min.poll();
            mid1.add(cur);
            mid2.add(cur);
            sum += cur;
        }
        if (max.size() > k) {
            int cur = max.poll();
            mid1.add(cur);
            mid2.add(cur);
            sum += cur;
        }
        if (list.size() > m) {
            int temp = list.get(list.size() - 1 - m);
            if (min.peek() >= temp) {
                min.remove(temp);
            } else if (max.peek() <= temp) {
                max.remove(temp);
            } else {
                mid1.remove(temp);
                mid2.remove(temp);
                sum -= temp;
            }
        }
        if (list.size() >= m) {
            while (min.size() < k) {
                int temp = mid1.poll();
                mid2.remove(temp);
                sum -= temp;
                min.offer(temp);
            }
            while (max.size() < k) {
                int temp = mid2.poll();
                mid1.remove(temp);
                sum -= temp;
                max.offer(temp);
            }
        }
    }

    public int calculateMKAverage() {
        if (list.size() < m) {
            return -1;
        }
        return (int) (sum / (m - 2 * k));
    }
}
