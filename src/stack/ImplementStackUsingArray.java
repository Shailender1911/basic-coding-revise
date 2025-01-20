package stack;

public class ImplementStackUsingArray {
    private int[] stack;
    private int top;
    private int capacity;

    // Constructor to initialize the stack
    public ImplementStackUsingArray(int size) {
        stack = new int[size];
        capacity = size;
        top = -1;
    }

    // Method to add an element to the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = value;
    }

    // Method to remove an element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }

    // Method to return the top element of the stack
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    public static void main(String[] args) {
        ImplementStackUsingArray stack = new ImplementStackUsingArray(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Top element is: " + stack.peek());
        System.out.println("Stack full: " + stack.isFull());

        stack.pop();
        stack.pop();

        System.out.println("Top element is: " + stack.peek());
        System.out.println("Stack empty: " + stack.isEmpty());
    }
}