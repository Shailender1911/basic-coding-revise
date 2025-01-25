package collection.arraylist;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {

        // CopyOnWriteArrayList is a thread-safe variant of ArrayList
        // It creates a new copy of the underlying array every time an element is added, modified, or removed
        // This is achieved by using an immutable snapshot of the list while performing modifications
        // This makes it suitable for use in a multi-threaded environment
        // It is not suitable for use cases where the list is modified frequently
        // It is also not suitable for use cases where the list is large and modifications are expensive
        // Create a CopyOnWriteArrayList
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // Add elements to the list
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Print the initial list
        System.out.println("Initial List: " + list);

        // Using an iterator to traverse the list
        System.out.println("\nIterating over the list:");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);

            // Add a new element during iteration
            // This will not affect the current iterator because it works on a snapshot
            if (element.equals("Banana")) {
                list.add("Date");
            }
        }

        // Print the list after modifications
        System.out.println("\nList after modification during iteration: " + list);

        // Removing an element from the list
        list.remove("Apple");
        System.out.println("\nList after removing 'Apple': " + list);
    }
}
