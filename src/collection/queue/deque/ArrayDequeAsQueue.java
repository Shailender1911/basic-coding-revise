package collection.queue.deque;

import java.util.ArrayDeque;

public class ArrayDequeAsQueue {

    public static void main(String[] args) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.addLast(10);
        queue.addLast(20);
        queue.addLast(30);
        queue.addLast(40);
        // checking removal of elements from the queue
        System.out.println("Before removing "+ queue);
        queue.removeFirst();
        System.out.println("After removing "+ queue);
    }




}
