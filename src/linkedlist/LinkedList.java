//package linkedlist;
//
//public class LinkedList {
//    Node head;
//
//    public static class Node {
//        Node next;
//        int data;
//
//        public Node(int data) {
//            this.data = data;
//            this.next = null;
//        }
//    }
//
//    private void addFront(int data) {
//        Node newNode = new Node(data);
//        newNode.next = head;
//        head = newNode;
//    }
//
//    public void addLast(int data) {
//        Node newNode = new Node(data);
//        if (head == null) {
//            head = newNode;
//            return;
//        }
//        Node temp = head;
//        while (temp.next != null) { // Traverse to the last node
//            temp = temp.next;
//        }
//        temp.next = newNode; // Update the next reference of the last node
//    }
//
//    private void addNthPosition(int data, int n)
//    {
//        Node temp = head;
//       while()
//    }
//
//    private void displayNode() {
//        System.out.println("Printing List");
//        Node temp = head; // Use a temporary pointer to traverse the list
//        while (temp != null) {
//            System.out.println(temp.data);
//            temp = temp.next;
//        }
//    }
//
//
//
//    public static void main(String[] args) {
//        LinkedList l = new LinkedList();
//        l.addFront(10);
//        l.addFront(20);
//        l.addFront(30);
//        l.addFront(40);
//        l.displayNode(); // Output: 40 30 20 10
//        l.addLast(50);
//        l.displayNode(); // Output: 40 30 20 10 50
//        // add at Kth position
//
//    }
//}
