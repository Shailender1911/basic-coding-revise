package multithreading;

import java.util.ArrayDeque;
import java.util.Queue;

public class SharedResource {
    private int bufferSize;
    private Queue<Integer> sharedBuffer;

    public SharedResource(int bufferSize) {
        this.bufferSize = bufferSize;
        this.sharedBuffer = new ArrayDeque<>(bufferSize);
    }

    public void produce(int value) throws InterruptedException {
        synchronized (sharedBuffer) {
            while (sharedBuffer.size() == bufferSize) {
                System.out.println("Buffer is full. Producer is waiting...");
                sharedBuffer.wait();
            }
            sharedBuffer.add(value);
            System.out.println("Produced: " + value);
            sharedBuffer.notify();
        }
    }

    public int consume() throws InterruptedException {
        synchronized (sharedBuffer) {
            while (sharedBuffer.isEmpty()) {
                System.out.println("Buffer is empty. Consumer is waiting...");
                sharedBuffer.wait();
            }
            int value = sharedBuffer.poll();
            System.out.println("Consumed: " + value);
            sharedBuffer.notify();
            return value;
        }
    }
}