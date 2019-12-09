package design.circular.deque;

/**
 * @author hum
 */
public class DesignCircularDeque {
    int[] queue;
    int front;
    int rear;
    int size;
    int capacity;

    public DesignCircularDeque(int k) {
        this.queue = new int[k];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        this.capacity = k;
    }


    public boolean insertFront(int value) {
        if (rear == front && size == capacity) {
            return false;
        } else {
            front = (front + capacity - 1) % capacity;
            queue[front] = value;
            size++;
            return true;
        }
    }


    public boolean insertLast(int value) {
        if (rear == front && size == capacity) {
            return false;
        } else {
            queue[rear] = value;
            rear = (rear + 1 + capacity) % capacity;
            size++;
            return true;
        }
    }

    public boolean deleteFront() {
        if (rear == front && size == 0) {
            return false;
        } else {
            front = (front + 1) % capacity;
            size--;
            return true;
        }
    }

    public boolean deleteLast() {
        if (rear == front && size == 0) {
            return false;
        } else {
            rear = (rear - 1 + capacity) % capacity;
            size--;
            return true;
        }
    }

    public int getFront() {
        if ((rear == front) && size == 0) {
            return -1;
        } else {
            return queue[front];
        }

    }

    public int getRear() {
        if ((rear == front) && size == 0) {
            return -1;
        } else {
            return queue[(rear - 1 + capacity) % capacity];
        }

    }


    public boolean isEmpty() {
        return (rear == front) && size == 0;
    }

    public boolean isFull() {
        return rear == front && size == capacity;
    }
}
