package find.median.from.data.stream;

import java.util.PriorityQueue;

/**
 * @author hum
 */
public class FindMedianFromDataStream {

    private PriorityQueue<Integer> maxheap;
    private PriorityQueue<Integer> minheap;

    public FindMedianFromDataStream() {
        maxheap = new PriorityQueue<>((x, y) -> y - x);
        minheap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        minheap.offer(num);
        maxheap.offer(minheap.poll());
        if (maxheap.size() > minheap.size() + 1) {
            minheap.offer(maxheap.poll());
        }
        System.out.println(minheap);
    }

    public double findMedian() {
        if (maxheap.size() == minheap.size()) {
            return (double) (minheap.peek() + maxheap.peek()) / 2;
        } else {
            return (double) maxheap.peek();
        }
    }
}
