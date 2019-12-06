package design.circular.queue;


public class DesignCircularQueue {
    private int maxSize;
    private int front = 0;
    private int rear = 0;
    private int[] arr;

    public DesignCircularQueue(int k) {
        maxSize = k + 1;
        arr = new int[maxSize];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            arr[rear] = value;
            rear = (rear + 1) % maxSize;
            return true;
        }
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            front = (front + 1) % maxSize;
            return true;
        }
    }

    public int front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    public int rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(rear - 1 + maxSize) % maxSize];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }
}
