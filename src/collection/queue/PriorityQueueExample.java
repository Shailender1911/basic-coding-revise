package collection.queue;

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>( (Integer a , Integer b) -> b - a);

        // by default the PQ  queue is min heap , but if we want to make it max heap we can use the above lambda expression
        // or we can use Collections.reverseOrder() as well
        // we need to provide the comparator in the constructor of the PriorityQueue
        pq.add(10);
        pq.add(20);
        pq.add(15);
        pq.add(5);
        pq.add(25);
        System.out.println("Priority Queue: " + pq);
        System.out.println("Head Element: " + pq.peek());
        System.out.println("Head Element: " + pq.poll());
        System.out.println("Priority Queue: " + pq);


    }
}