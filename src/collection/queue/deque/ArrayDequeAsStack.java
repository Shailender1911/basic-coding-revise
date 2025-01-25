package collection.queue.deque;

import java.util.ArrayDeque;

public class ArrayDequeAsStack {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // Pushing elements onto the stack
        stack.addFirst(10);
        stack.addFirst(20);
        stack.addFirst(30);
        stack.addFirst(40);

        // Popping elements from the stack
        System.out.println("Before popping: " + stack);
        stack.removeFirst();
        System.out.println("After popping: " + stack);
    }
}