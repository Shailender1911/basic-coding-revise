Here is the refactored `README.md` with proper headings and formatting:

---

# Understanding `Callable` and `Runnable` in Java

`Callable` and `Runnable` are two interfaces in Java commonly used to represent tasks that can be executed by a thread.
They are pivotal in multithreading and concurrent programming. This guide explains their characteristics, usage, and
differences.

---

## Table of Contents

1. [Runnable](#runnable)
    - Definition
    - Characteristics
    - Usage
    - Example
    - Pros and Cons
2. [Callable](#callable)
    - Definition
    - Characteristics
    - Usage
    - Example
    - Pros and Cons
3. [Comparison](#comparison)
4. [When to Use](#when-to-use)
5. [Practical Example](#practical-example)
6. [Key Points](#key-points)

---

## Runnable

### Definition

`Runnable` is a functional interface representing a task to be executed by a thread. It includes a single method:

```java
void run();
```

### Characteristics

- Does not return a result.
- Cannot throw checked exceptions.
- Ideal for tasks where a result or exception handling is unnecessary.

### Usage

Use `Runnable` for fire-and-forget tasks or lightweight multithreading operations.

### Example

```java
public class RunnableExample {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Task is running...");

        Thread thread = new Thread(task);
        thread.start();
    }
}
```

### Pros

1. Simple and easy to implement.
2. Suitable for lightweight tasks.
3. Supported extensively in legacy code and frameworks.

### Cons

1. Cannot return results.
2. No support for checked exceptions.
3. Limited flexibility.

---

## Callable

### Definition

`Callable` is a functional interface introduced in Java 5 under `java.util.concurrent`. It provides a method for
executing tasks:

```java
V call() throws Exception;
```

### Characteristics

- Returns a result of type `V`.
- Can throw checked exceptions.
- Used with `ExecutorService` for task management.

### Usage

Use `Callable` when a task requires a result or exception handling.

### Example

```java
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> task = () -> {
            Thread.sleep(2000); // Simulate work
            return "Task completed!";
        };

        Future<String> future = executor.submit(task);

        try {
            System.out.println("Result: " + future.get());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            executor.shutdown();
        }
    }
}
```

### Pros

1. Returns results after execution.
2. Allows handling of checked exceptions.
3. Highly compatible with modern concurrency frameworks.

### Cons

1. Slightly more complex to manage.
2. Requires `Future` and `ExecutorService`.
3. May block threads if results are not handled asynchronously.

---

## Comparison

| Feature            | Runnable                    | Callable                                      |
|--------------------|-----------------------------|-----------------------------------------------|
| Method Signature   | `void run()`                | `V call() throws Exception`                   |
| Return Value       | None                        | Result of type `V`                            |
| Exception Handling | No checked exceptions       | Supports checked exceptions                   |
| Use Case           | Fire-and-forget tasks       | Tasks requiring results or exception handling |
| API Integration    | `Thread`, `ExecutorService` | `ExecutorService`                             |

---

## When to Use

- **Use `Runnable`:**
    - For simple, non-blocking tasks like logging or notifications.
    - When results or exceptions are unnecessary.
    - In lightweight or legacy threading scenarios.

- **Use `Callable`:**
    - For tasks requiring a return value or exception handling.
    - In modern multithreading applications using `ExecutorService`.

---

## Practical Example

### Scenario

Calculate the sum of numbers from 1 to 100 using both `Runnable` and `Callable`.

#### Using `Runnable`

```java
public class RunnableSum {
    static int result = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 1; i <= 100; i++) {
                result += i;
            }
        };

        Thread thread = new Thread(task);
        thread.start();
        thread.join();

        System.out.println("Sum: " + result);
    }
}
```

#### Using `Callable`

```java
import java.util.concurrent.*;

public class CallableSum {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
            return sum;
        };

        Future<Integer> future = executor.submit(task);

        try {
            System.out.println("Sum: " + future.get());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
```

---

## Key Points

- Prefer `Runnable` for simple, non-blocking tasks without return values.
- Use `Callable` for tasks requiring results or checked exception handling.
- Modern Java practices favor `Callable` with `ExecutorService` for flexible and robust concurrency.

---

This structure provides a clear, well-organized explanation of `Runnable` and `Callable` while maintaining readability.

Here is a formatted version of your content:

---

# Java Exceptions and Thread Class Methods

## Checked Exceptions

### **Definition:**

Checked exceptions are exceptions that are checked at compile time. The compiler forces the programmer to either:

- Handle these exceptions using `try-catch`, or
- Declare them in the method signature using `throws`.

### **Examples:**

- `IOException`
- `SQLException`
- `InterruptedException`

### **Propagation of Checked Exceptions:**

- A method throwing a checked exception **must declare it** in its `throws` clause.
- If not handled, the exception propagates up the call stack until caught or the program terminates.

#### **Example:**

```java
class CheckedExceptionExample {
    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) {
            System.out.println("Handled exception: " + e.getMessage());
        }
    }

    static void methodA() throws Exception {
        methodB();
    }

    static void methodB() throws Exception {
        throw new Exception("Checked exception");
    }
}
```

**Output:**

```
Handled exception: Checked exception
```

#### **Explanation:**

1. `methodB()` throws a checked exception.
2. `methodA()` propagates it using its `throws` clause.
3. The `main()` method handles the exception using a `try-catch` block.

---

## Unchecked Exceptions

### **Definition:**

Unchecked exceptions are exceptions that are not checked at compile time. These occur due to programming errors and are
subclasses of `RuntimeException`.

### **Examples:**

- `NullPointerException`
- `ArrayIndexOutOfBoundsException`
- `IllegalArgumentException`

### **Propagation of Unchecked Exceptions:**

- Unchecked exceptions **do not require** declaration in the `throws` clause.
- If not handled, they propagate automatically up the call stack and may terminate the program.

#### **Example:**

```java
class UncheckedExceptionExample {
    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) {
            System.out.println("Handled exception: " + e.getMessage());
        }
    }

    static void methodA() {
        methodB();
    }

    static void methodB() {
        throw new NullPointerException("Unchecked exception");
    }
}
```

**Output:**

```
Handled exception: Unchecked exception
```

#### **Explanation:**

1. `methodB()` throws an unchecked exception (`NullPointerException`).
2. `methodA()` does not require a `throws` clause.
3. The `main()` method handles the exception using a `try-catch` block.

---

## Key Differences in Propagation

| **Aspect**                | **Checked Exceptions**                     | **Unchecked Exceptions**                       |  
|---------------------------|--------------------------------------------|------------------------------------------------|  
| **Compile-Time Check**    | Yes, must be declared or handled.          | No, not checked at compile time.               |  
| **Declaration in throws** | Required.                                  | Not required.                                  |  
| **Propagation**           | Explicit handling or declaration required. | Propagates automatically.                      |  
| **Examples**              | `IOException`, `SQLException`.             | `NullPointerException`, `ArithmeticException`. |  

---

## Practical Use Cases

### **Checked Exceptions:**

- Use for predictable, recoverable scenarios like:
    - File not found (`IOException`).
    - Database connectivity issues (`SQLException`).

#### **Example:**

```java
void readFile() throws IOException {
    Files.readAllLines(Paths.get("nonexistent.txt"));
}
```

### **Unchecked Exceptions:**

- Use for programming errors or invalid states like:
    - Null pointer dereference (`NullPointerException`).
    - Invalid arguments (`IllegalArgumentException`).

#### **Example:**

```java
void divide(int a, int b) {
    if (b == 0) throw new ArithmeticException("Cannot divide by zero");
    System.out.println(a / b);
}
```

---

## Java Thread Class Methods

### **join vs wait**

| **Feature**         | **join**                                | **wait**                                      |  
|---------------------|-----------------------------------------|-----------------------------------------------|  
| **Defined In**      | `Thread` class                          | `Object` class                                |  
| **Purpose**         | Waits for a thread to finish execution. | Waits for a notification from another thread. |  
| **Synchronization** | Not required.                           | Requires synchronization (`synchronized`).    |  
| **How to Notify**   | Not applicable.                         | Use `notify()` or `notifyAll()`.              |  

### **Examples:**

#### **join()**

```java
public class JoinExample {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1 - " + i);
            }
        });

        t1.start();
        t1.join(); // Main thread waits for t1 to finish

        System.out.println("Main thread resumes after t1 completes.");
    }
}
```

#### **wait()**

```java
public class WaitExample {
    public static void main(String[] args) {
        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 1 waiting...");
                    lock.wait(); // Thread 1 waits for notification
                    System.out.println("Thread 1 resumed.");
                } catch (InterruptedException e) {
                    System.out.println(e);                }
            }
        });

        t1.start();

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 2 notifying...");
                lock.notify(); // Notifies Thread 1
            }
        });

        t2.start();
    }
}
```

---

## Other Thread Methods

| **Method**    | **Purpose**                                    | **Defined In** |  
|---------------|------------------------------------------------|----------------|  
| `sleep()`     | Pauses thread execution for a specified time.  | `Thread` class |  
| `yield()`     | Suggests giving other threads a chance to run. | `Thread` class |  
| `interrupt()` | Interrupts a thread in blocking operations.    | `Thread` class |  
| `isAlive()`   | Checks if a thread is alive.                   | `Thread` class |  

---

## Best Practices

1. Use `join` for dependency between threads and `wait/notify` for communication.
2. Always handle `InterruptedException` properly.
3. Prefer higher-level concurrency APIs like `ExecutorService` for complex tasks.

## Other Important Thread Methods

### 1. **sleep()**

- **Purpose**: Causes the current thread to pause execution for a specified duration.
- **Defined In**: `Thread` class.
- **Method Signature**:
  public static void sleep(long millis) throws InterruptedException
- **Example**:

  public class SleepExample {
  public static void main(String[] args) throws InterruptedException {
  System.out.println("Main thread sleeping...");
  Thread.sleep(2000); // Sleep for 2 seconds
  System.out.println("Main thread resumes after sleep.");
  }
  }

---

### 2. **yield()**

- **Purpose**: Suggests that the current thread is willing to yield its execution to other threads of the same priority.
- **Defined In**: `Thread` class.
- **Method Signature**:
  ```java
  public static void yield();
  ```
- **Example**:
  ```java
  public class YieldExample {
      public static void main(String[] args) {
          Thread t1 = new Thread(() -> {
              for (int i = 0; i < 5; i++) {
                  System.out.println("Thread 1 - " + i);
                  Thread.yield();
              }
          });

          Thread t2 = new Thread(() -> {
              for (int i = 0; i < 5; i++) {
                  System.out.println("Thread 2 - " + i);
              }
          });

          t1.start();
          t2.start();
      }
  }
  ```

---

### 3. **interrupt()**

- **Purpose**: Interrupts a thread, which can break its blocking operations like `sleep` or `wait`.
- **Defined In**: `Thread` class.
- **Method Signature**:
  ```java
  public void interrupt();
  ```
- **Example**:
  ```java
  public class InterruptExample {
      public static void main(String[] args) {
          Thread t1 = new Thread(() -> {
              try {
                  Thread.sleep(5000);
              } catch (InterruptedException e) {
                  System.out.println("Thread interrupted!");
              }
          });

          t1.start();
          t1.interrupt(); // Interrupt the thread
      }
  }
  ```

---

### 4. **isAlive()**

- **Purpose**: Checks if a thread is alive (i.e., started and not yet terminated).
- **Defined In**: `Thread` class.
- **Method Signature**:
  ```java
  public final boolean isAlive();
  ```
- **Example**:
  ```java
  public class IsAliveExample {
      public static void main(String[] args) throws InterruptedException {
          Thread t1 = new Thread(() -> System.out.println("Thread is running..."));

          System.out.println("Is thread alive before start? " + t1.isAlive());
          t1.start();
          System.out.println("Is thread alive after start? " + t1.isAlive());
      }
  }
  ```

---

## Best Practices

1. Use `join` for dependency between threads and `wait/notify` for thread communication.
2. Always handle `InterruptedException` properly when using methods like `sleep`, `wait`, or `join`.
3. Use `isAlive()` for thread status checks during debugging or task monitoring.
4. Minimize the use of `Thread.yield()` as it is dependent on thread priorities, which vary between platforms.
5. Prefer higher-level concurrency APIs like `ExecutorService` and `CompletableFuture` over manual thread management
   where possible.

---

## Conclusion

Understanding Java exceptions and thread methods is crucial for writing robust and efficient multithreaded applications.
By mastering these concepts, you can handle errors effectively and manage threads efficiently.

# Differences in Java Multithreading Concepts

### 1. Difference Between `Thread` and `Runnable`

| **Aspect**      | **Thread**                                                              | **Runnable**                                               |
|-----------------|-------------------------------------------------------------------------|------------------------------------------------------------|
| **Inheritance** | Extends the `Thread` class.                                             | Implements the `Runnable` interface.                       |
| **Flexibility** | Can’t extend another class (Java doesn’t support multiple inheritance). | Can extend another class as it only implements `Runnable`. |
| **Usage**       | Creates a new thread directly.                                          | Requires passing an instance to a `Thread` object.         |
| **Example**     | `class MyThread extends Thread {}`                                      | `class MyRunnable implements Runnable {}`                  |

---

### 2. Difference Between `start()` and `run()`

| **Aspect**           | **start()**                               | **run()**                               |
|----------------------|-------------------------------------------|-----------------------------------------|
| **Thread Execution** | Creates a new thread and invokes `run()`. | Executes `run()` in the current thread. |
| **Concurrency**      | Code runs in a separate thread.           | Code runs in the calling thread.        |
| **Usage**            | Used to start a new thread.               | Used when no multithreading is needed.  |
| **Example**          | `thread.start();`                         | `thread.run();`                         |

---

### 3. Difference Between `synchronized` and `Lock`

| **Aspect**           | **synchronized**                           | **Lock**                                          |
|----------------------|--------------------------------------------|---------------------------------------------------|
| **Type**             | Implicit locking.                          | Explicit locking (`ReentrantLock`).               |
| **Interruptibility** | Not interruptible.                         | Can be interrupted (`lockInterruptibly()`).       |
| **Performance**      | Less flexible but easier to use.           | Provides better performance under contention.     |
| **Try Lock**         | Not possible.                              | Supported using `tryLock()`.                      |
| **Unlocking**        | Automatic unlocking after block execution. | Requires explicit unlocking.                      |
| **Example**          | `synchronized(obj) {}`                     | `lock.lock(); // Critical section lock.unlock();` |

---

### 4. Difference Between `volatile` and `synchronized`

| **Aspect**        | **volatile**                                           | **synchronized**                               |
|-------------------|--------------------------------------------------------|------------------------------------------------|
| **Purpose**       | Ensures visibility of variable changes across threads. | Ensures mutual exclusion and visibility.       |
| **Locking**       | No locking mechanism.                                  | Provides locking mechanism.                    |
| **Thread Safety** | Doesn’t guarantee atomicity.                           | Guarantees atomicity.                          |
| **Usage**         | For flags or status variables.                         | For critical sections with complex operations. |
| **Example**       | `volatile boolean flag = true;`                        | `synchronized void method() {}`                |

---

### 5. Difference Between `Thread` and `Process`

| **Aspect**        | **Thread**                                            | **Process**                                   |
|-------------------|-------------------------------------------------------|-----------------------------------------------|
| **Definition**    | Lightweight unit of execution within a process.       | Independent unit of execution.                |
| **Memory**        | Shares memory with other threads in the same process. | Has its own memory space.                     |
| **Communication** | Easier (shared memory).                               | More complex (Inter-Process Communication).   |
| **Overhead**      | Lower.                                                | Higher due to memory and resource allocation. |

---

### 6. Difference Between Thread Pool (`ExecutorService`) and Creating Threads

| **Aspect**      | **Thread Pool (`ExecutorService`)**                           | **Creating Threads**                          |
|-----------------|---------------------------------------------------------------|-----------------------------------------------|
| **Performance** | Efficient for large numbers of tasks.                         | Expensive for a large number of threads.      |
| **Reuse**       | Reuses threads to reduce overhead.                            | Creates new threads every time.               |
| **Management**  | Managed via APIs like `submit()` or `shutdown()`.             | Manually managed (e.g., `start()`, `join()`). |
| **Example**     | `ExecutorService executor = Executors.newFixedThreadPool(5);` | `Thread thread = new Thread();`               |

---

### 7. Difference Between `Runnable` and `Callable`

| **Aspect**             | **Runnable**                                 | **Callable**                                                    |
|------------------------|----------------------------------------------|-----------------------------------------------------------------|
| **Return Type**        | Doesn’t return a result (`void`).            | Returns a result (`Future<V>`).                                 |
| **Exception Handling** | Can’t throw checked exceptions.              | Can throw checked exceptions.                                   |
| **Introduced In**      | Java 1.0.                                    | Java 5 (with `java.util.concurrent`).                           |
| **Usage**              | Suitable for simple tasks.                   | Suitable for tasks needing results.                             |
| **Example**            | `Thread t = new Thread(new RunnableTask());` | `Future<Integer> result = executor.submit(new CallableTask());` |

---

### 8. Difference Between `wait()` and `sleep()`

| **Aspect**        | **wait()**                                    | **sleep()**                            |
|-------------------|-----------------------------------------------|----------------------------------------|
| **Belongs To**    | Object class.                                 | Thread class.                          |
| **Purpose**       | Releases the lock and waits for notification. | Pauses execution for a specified time. |
| **Lock Handling** | Releases the lock it holds.                   | Doesn’t release any locks.             |
| **Usage**         | Used for inter-thread communication.          | Used for making a thread sleep.        |
| **Example**       | `wait();`                                     | `Thread.sleep(1000);`                  |

---

### 9. Difference Between Deadlock and Starvation

| **Aspect**     | **Deadlock**                                          | **Starvation**                                                           |
|----------------|-------------------------------------------------------|--------------------------------------------------------------------------|
| **Definition** | Two or more threads wait indefinitely for each other. | A thread waits indefinitely because higher-priority threads are running. |
| **Cause**      | Circular dependency on resources.                     | Resource scheduling unfairness.                                          |
| **Prevention** | Avoid nested locks, apply timeout.                    | Use fair scheduling policies.                                            |

---

### 10. Difference Between `notify()` and `notifyAll()`

| **Aspect**     | **notify()**                                | **notifyAll()**                                       |
|----------------|---------------------------------------------|-------------------------------------------------------|
| **Purpose**    | Wakes up one waiting thread.                | Wakes up all waiting threads.                         |
| **Efficiency** | More efficient as it wakes only one thread. | Less efficient but ensures no thread is left waiting. |
| **Usage**      | Use when you know which thread to wake.     | Use when all threads need to continue.                |

---

### Comparable vs Comparator in Java

Use `Comparable` when you want to define a natural ordering for the objects of a class. This is done by implementing the
`Comparable` interface and overriding the `compareTo` method. This approach is suitable when the class has a single,
natural way of ordering its instances.

Example:

```java
public class Car implements Comparable<Car> {
    private String name;
    private String fuelType;
    private Integer price;

    public Car(String name, String fuelType, Integer price) {
        this.name = name;
        this.fuelType = fuelType;
        this.price = price;
    }

    @Override
    public int compareTo(Car o) {
        return this.price.compareTo(o.price);
    }
}
```

Use `Comparator` when you want to define multiple ways of ordering objects, or when you want to define an ordering for a
class that does not have a natural ordering. This is done by creating a class that implements the `Comparator` interface
and overriding the `compare` method.

Example:

```java
import java.util.Comparator;

public class CarPriceComparator implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) {
        return c1.getPrice().compareTo(c2.getPrice());
    }
}
```

You can then use the `Comparator` to sort a collection of `Car` objects:

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("BMW", "Petrol", 5000000);
        Car car2 = new Car("Audi", "Diesel", 6000000);
        Car car3 = new Car("Mercedes", "Petrol", 7000000);
        Car[] cars = new Car[]{car1, car2, car3};

        Arrays.sort(cars, new CarPriceComparator());
        System.out.println(cars[0].getName());
    }
}
```

## ArrayDeque vs LinkedList in Java

`ArrayDeque` is a resizable array implementation of the `Deque` interface. It can be used as both a stack (LIFO) and a
queue (FIFO). Here are some common usages of `ArrayDeque`:

### 1. Using `ArrayDeque` as a Queue (FIFO)

```java
import java.util.ArrayDeque;

public class ArrayDequeAsQueue {
    public static void main(String[] args) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        // Adding elements to the queue
        queue.addLast(10);
        queue.addLast(20);
        queue.addLast(30);
        queue.addLast(40);

        // Removing elements from the queue
        System.out.println("Before removing: " + queue);
        queue.removeFirst();
        System.out.println("After removing: " + queue);
    }
}
```

### 2. Using `ArrayDeque` as a Stack (LIFO)

```java
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
```

### 3. Common Operations

```java
import java.util.ArrayDeque;

public class ArrayDequeOperations {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // Adding elements
        deque.addFirst(10);
        deque.addLast(20);

        // Accessing elements
        System.out.println("First element: " + deque.getFirst());
        System.out.println("Last element: " + deque.getLast());

        // Removing elements
        deque.removeFirst();
        deque.removeLast();

        // Checking if empty
        System.out.println("Is deque empty? " + deque.isEmpty());
    }
}
```

### Key Points

- `ArrayDeque` is not thread-safe.
- It is more memory efficient and faster than `LinkedList` for stack and queue operations.
- It does not allow `null` elements.

### Performance Differences Between `ArrayDeque` and `LinkedList`

#### **ArrayDeque**

- **Memory Efficiency**: More memory efficient as it uses a resizable array.
- **Speed**: Generally faster for stack and queue operations due to contiguous memory allocation.
- **Insertion/Removal**: O(1) for operations at both ends (addFirst, addLast, removeFirst, removeLast).
- **Random Access**: O(1) for accessing elements by index, but not supported directly as it is not a List.

#### **LinkedList**

- **Memory Efficiency**: Less memory efficient due to the overhead of storing node pointers.
- **Speed**: Slower compared to `ArrayDeque` for stack and queue operations due to non-contiguous memory allocation.
- **Insertion/Removal**: O(1) for operations at both ends (addFirst, addLast, removeFirst, removeLast), but O(n) for
  operations in the middle.
- **Random Access**: O(n) for accessing elements by index, as it requires traversal from the head or tail.

### Summary

- **ArrayDeque** is generally preferred for stack and queue operations due to its better performance and memory
  efficiency.
- **LinkedList** is useful when frequent insertions and deletions in the middle of the list are required.

## CopyOnWriteArrayList

`CopyOnWriteArrayList` is a thread-safe variant of `ArrayList`. It creates a new copy of the underlying array every time
an element is added, modified, or removed. This is achieved by using an immutable snapshot of the list while performing
modifications. This makes it suitable for use in a multi-threaded environment. However, it is not suitable for use cases
where the list is modified frequently or where the list is large and modifications are expensive.

### Example

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

---

# **ExecutorService in Java**

## **What is `ExecutorService`?**

`ExecutorService` is an interface in Java's `java.util.concurrent` package that provides a high-level way to manage and
control thread execution. It abstracts the complexity of thread creation, management, and execution, allowing tasks to
be executed asynchronously.

Instead of manually creating and managing threads, `ExecutorService` allows you to:

- Submit tasks for execution.
- Manage thread pools efficiently.
- Control concurrent execution without manually handling threads.

---

## **When to Use `ExecutorService`?**

Use `ExecutorService` when:
✅ **Multiple tasks need to run concurrently** without manually managing threads.  
✅ **Thread pooling is required** to optimize performance and resource usage.  
✅ **Thread execution needs better control**, such as scheduling, cancellation, or limiting concurrency.  
✅ **Handling task results** (with `Callable` and `Future`).  
✅ **Reusing existing threads** rather than creating new threads for each task (which is resource-intensive).

---

## **Alternatives to `ExecutorService`**

If `ExecutorService` is not suitable, consider these alternatives:

### **1. Manually Creating Threads**

Manually starting a new thread:

```java
Thread thread = new Thread(() -> {
    System.out.println("Task executed by thread: " + Thread.currentThread().getName());
});

//thread.start();
```

📌 **Limitations**: Inefficient for handling multiple tasks due to high resource consumption.

---

### **2. Using `ForkJoinPool` (Best for Recursive Tasks)**

`ForkJoinPool` is optimized for parallel computing, especially for recursive tasks.

```java
/*ForkJoinPool pool = new ForkJoinPool();
pool.submit(() -> System.out.println("Task executed using ForkJoinPool"));
pool.shutdown(); */
```

📌 **Best for**: Divide-and-conquer algorithms, parallel computation.

---

### **3. Using `CompletableFuture` (Best for Asynchronous Programming)**

`CompletableFuture` offers flexible handling of asynchronous computations.

```java
/*CompletableFuture.supplyAsync(() ->"Hello, Async!").

thenAccept(System.out::println); */
```

📌 **Best for**: Non-blocking execution, combining async tasks.

---

## **Types of `ExecutorService` Implementations**

| Executor Type                                                      | Best For                             | Example                                                                    |
|--------------------------------------------------------------------|--------------------------------------|----------------------------------------------------------------------------|
| **Fixed Thread Pool** (`Executors.newFixedThreadPool(n)`)          | **Fixed number of tasks**            | `ExecutorService executor = Executors.newFixedThreadPool(5);`              |
| **Cached Thread Pool** (`Executors.newCachedThreadPool()`)         | **Short-lived, unpredictable tasks** | `ExecutorService executor = Executors.newCachedThreadPool();`              |
| **Single Thread Executor** (`Executors.newSingleThreadExecutor()`) | **Sequential execution of tasks**    | `ExecutorService executor = Executors.newSingleThreadExecutor();`          |
| **Scheduled Thread Pool** (`Executors.newScheduledThreadPool(n)`)  | **Delayed or periodic execution**    | `ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);` |

---

## **Benefits of Using `ExecutorService`**

### ✅ **1. Thread Reusability (Better Performance)**

- Reduces overhead by **reusing threads** instead of creating new ones.

### ✅ **2. Better Resource Management**

- Prevents excessive thread creation, reducing performance bottlenecks.

### ✅ **3. Easy Task Management**

- Supports **asynchronous execution** of `Runnable` and `Callable` tasks.
- Provides `Future` objects for handling results.

### ✅ **4. Graceful Shutdown Handling**

- Supports proper termination using `shutdown()` and `shutdownNow()`.

### ✅ **5. Flexible Scheduling**

- Allows **fixed-rate or delayed task execution**.

---

## **Example: Using `ExecutorService` with Multiple Threads**

```java
import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
            });
        }

        executor.shutdown(); // Shutdown the executor
    }
}
```

### **Output (Threads are reused)**

```
Task 1 executed by pool-1-thread-1
Task 2 executed by pool-1-thread-2
Task 3 executed by pool-1-thread-3
Task 4 executed by pool-1-thread-1
Task 5 executed by pool-1-thread-2
```

---

## **When NOT to Use `ExecutorService`**

❌ **For a single, short-lived task** (a simple `Thread` is sufficient).  
❌ **When fine-grained control over thread execution is needed**.  
❌ **In reactive programming models** (`CompletableFuture` or `Reactive Streams` may be better).

---

## **Conclusion**

🔹 **Use `ExecutorService` for efficient task management and concurrency handling.**  
🔹 **Choose the right executor type based on workload and performance needs.**  
🔹 **Consider alternatives like `ForkJoinPool` and `CompletableFuture` for specific use cases.**  
🔹 **It simplifies concurrency, improves performance, and efficiently manages threads.**

Would you like a deep dive into **shutdown strategies** or **thread pool tuning**? 🚀

## **ThreadPoolExecutor vs ExecutorService in Java**

### **1. ExecutorService**

`ExecutorService` is a high-level **interface** in the `java.util.concurrent` package that provides a framework for
managing and controlling thread execution. It allows developers to execute tasks asynchronously without worrying about
low-level thread management.

### **2. ThreadPoolExecutor**

`ThreadPoolExecutor` is a **concrete implementation** of `ExecutorService`, providing fine-grained control over a thread
pool. It allows configuring:

- **Core pool size** (minimum number of threads)
- **Maximum pool size** (maximum number of threads)
- **Keep-alive time** (how long idle threads should wait before termination)
- **Work queue** (holds tasks before execution)

---

## **Key Differences Between ExecutorService and ThreadPoolExecutor**

| Feature           | `ExecutorService` (Interface)                                 | `ThreadPoolExecutor` (Implementation)                         |
|-------------------|---------------------------------------------------------------|---------------------------------------------------------------|
| **Type**          | Interface                                                     | Concrete class                                                |
| **Customization** | Limited control                                               | Full control over thread pool behavior                        |
| **Usage**         | Provides thread pool management                               | Allows detailed configuration of pool                         |
| **Configuration** | Uses factory methods (`Executors.newFixedThreadPool()`, etc.) | Manually configurable (core threads, queue, rejection policy) |
| **Preferred for** | General-purpose thread management                             | Advanced tuning of thread pools                               |

---

## **Example of Using `ExecutorService`**

`ExecutorService` can be created using factory methods from `Executors` class.

```java
import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        // Creating a Fixed Thread Pool with 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executorService.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
            });
        }

        executorService.shutdown(); // Shutdown the executor
    }
}

```

### **Output**

```
Task 1 executed by pool-1-thread-1
Task 2 executed by pool-1-thread-2
Task 3 executed by pool-1-thread-3
Task 4 executed by pool-1-thread-1
Task 5 executed by pool-1-thread-2
```

### **Why Use `ExecutorService`?**

- **Easier to use** (factory methods provide default configurations).
- **Automatic thread management** (reuses threads efficiently).
- **Handles `Runnable` and `Callable` tasks**.

---

## **Example of Using `ThreadPoolExecutor`**

If you need **more control**, use `ThreadPoolExecutor` directly.

```java
import java.util.concurrent.*;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {
        // Creating a ThreadPoolExecutor with custom settings
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,  // Core pool size
                5,  // Maximum pool size
                10, TimeUnit.SECONDS, // Keep-alive time
                new LinkedBlockingQueue<>(10), // Task queue
                new ThreadPoolExecutor.AbortPolicy() // Rejection policy
        );

        for (int i = 1; i <= 8; i++) {
            int taskId = i;
            executor.execute(() -> System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName()));
        }

        executor.shutdown();
    }
}
```

### **Output**

```
Task 1 executed by pool-1-thread-1
Task 2 executed by pool-1-thread-2
Task 3 executed by pool-1-thread-1
Task 4 executed by pool-1-thread-2
Task 5 executed by pool-1-thread-1
Task 6 executed by pool-1-thread-2
Task 7 executed by pool-1-thread-1
Task 8 executed by pool-1-thread-2
```

### **Why Use `ThreadPoolExecutor`?**

- **Allows fine-grained control** over thread pool behavior.
- **Configurable queue size**, thread count, keep-alive time.
- **Customizable rejection policy** for handling overloaded queues.

---

## **When to Use Which?**

| Use Case                                               | Recommended Approach                                     |
|--------------------------------------------------------|----------------------------------------------------------|
| General-purpose concurrency with simple thread pooling | `ExecutorService` (via `Executors.newFixedThreadPool()`) |
| Need precise control over thread pool behavior         | `ThreadPoolExecutor`                                     |
| Short-lived tasks with unknown workload                | `Executors.newCachedThreadPool()`                        |
| Periodic tasks (e.g., scheduled jobs)                  | `Executors.newScheduledThreadPool()`                     |

---

## **Conclusion**

- **`ExecutorService` is a high-level interface** that abstracts thread pool management.
- **`ThreadPoolExecutor` is a low-level implementation** that allows full customization.
- **For most use cases, `ExecutorService` via `Executors` factory methods is sufficient.**
- **Use `ThreadPoolExecutor` when you need advanced tuning, such as controlling queue size, rejection policy, or
  dynamically adjusting the pool.**

Absolutely! Let’s break down **serialization** in Java in a simple and clear way, along with a practical code example.

---

## ✅ What is Serialization?

**Serialization** is the process of **converting an object into a byte stream** so it can be:
- Saved to a file or database
- Sent over a network
- Cached or deep-cloned

Its opposite is **deserialization**, where you **reconstruct the object from the byte stream**.

---

## 📦 When You Serialize Fields

When you serialize an object:
- All **non-transient** and **non-static** fields are saved.
- All **transient** fields are **skipped**.
- **Static fields** belong to the class, not the object — so they're also skipped.

---

## ⚙️ How to Serialize in Java

1. The class must **implement `Serializable` interface**.
2. Fields are automatically serialized **unless marked `transient` or `static`**.

---

## 🧪 Example: Serialization in Action

```java
import java.io.*;

// Step 1: Make class Serializable
class User implements Serializable {
    String username;
    transient String password;  // Won’t be serialized
    static String type = "Admin"; // Won’t be serialized

    public User(String u, String p) {
        username = u;
        password = p;
    }
}

public class SerializeDemo {
    public static void main(String[] args) throws Exception {
        User user = new User("rishav", "secret");

        // Step 2: Serialize
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.ser"));
        out.writeObject(user);
        out.close();

        // Step 3: Deserialize
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.ser"));
        User deserializedUser = (User) in.readObject();
        in.close();

        System.out.println("Username: " + deserializedUser.username); // rishav
        System.out.println("Password: " + deserializedUser.password); // null (because transient)
        System.out.println("Type: " + deserializedUser.type);         // Admin (static, not serialized)
    }
}
```

---

## 🔍 Key Observations

- `username` was serialized and deserialized.
- `password` was **not** serialized (`transient` → becomes `null`).
- `type` was not serialized (`static` → belongs to class, not object).

---

## 🛡️ Why Use `transient`?
- Protect **sensitive data** like passwords, tokens.
- Avoid serializing **non-serializable** classes (e.g., `Thread`, `Socket`).
- Improve performance by skipping unnecessary fields.



`@RequestScope` is a Spring annotation that defines a **bean's lifecycle to match a single HTTP request**. A new instance of the bean is created for **each incoming request**, and it is **discarded once the request is completed**.

---

## ✅ Purpose of `@RequestScope`

- Used when you want a bean to **hold request-specific data**.
- Ensures **thread safety**, as each HTTP request gets its own bean instance.

---

## 🔍 Common Use Case

- Storing temporary user info, headers, or request-related computations.
- Tracking request-specific logs or audit data.

---

## 🧪 Example

```java
@Component
@RequestScope
public class RequestData {

    private final String requestId = UUID.randomUUID().toString();

    public String getRequestId() {
        return requestId;
    }
}
```

```java
@RestController
public class MyController {

    private final RequestData requestData;

    @Autowired
    public MyController(RequestData requestData) {
        this.requestData = requestData;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Request ID: " + requestData.getRequestId();
    }
}
```

### 📦 Behavior:
- Each `/hello` request gets a **fresh `RequestData` object** with a new ID.
- After the request finishes, Spring **discards the bean**.

---

## ⚠️ Important Notes

1. **`@RequestScope` only works in a web-aware context** (like Spring MVC or Spring Boot Web).
2. If you try to inject a `@RequestScope` bean into a **singleton bean**, it will fail unless:
    - You use **ObjectFactory**, **Provider**, or **proxy mode**.

### 🛠 Fix using proxy:

```java
@Component
@RequestScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestData {  }
```

Now Spring injects a **proxy object** into the singleton, which delegates to the correct instance per request.

---

## 🧠 Other Scopes in Spring

| Annotation       | Scope                      |
|------------------|----------------------------|
| `@Singleton` (default) | One instance for entire container |
| `@Prototype`     | New instance every time requested |
| `@RequestScope`  | One instance per HTTP request |
| `@SessionScope`  | One instance per HTTP session |
| `@ApplicationScope` | One instance for entire web app |

---

## ✅ Summary

| Feature         | `@RequestScope`                                  |
|------------------|--------------------------------------------------|
| Lifetime         | One HTTP request                                 |
| Thread-safe      | ✅ Yes (per-thread per-request)                  |
| Use case         | Request data, user context, temporary state      |
| Needs proxy for singleton | ✅ Yes, if injected into a singleton bean  |


Great! Let's dive into **`@SessionScope`** first, then show how to **inject request/session-scoped beans into singleton or async/scheduled contexts**, which can be tricky without proper setup.

---

## ✅ `@SessionScope`

### 📌 What is it?

`@SessionScope` is a Spring annotation that creates **one instance of a bean per HTTP session**. It’s useful for storing **user-specific data** that should persist across multiple requests during a session (e.g., login status, cart data).

---

### 🧪 Example

```java
@Component
@SessionScope
public class UserSession {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
```

```java
@RestController
public class SessionController {

    @Autowired
    private UserSession userSession;

    @PostMapping("/login")
    public String login(@RequestParam String name) {
        userSession.setUsername(name);
        return "Logged in as " + name;
    }

    @GetMapping("/user")
    public String getUser() {
        return "Current user: " + userSession.getUsername();
    }
}
```

> ✅ Same `UserSession` object is shared across multiple requests **from the same user/session**.

---

### ⚠ If Injecting into Singleton Bean

Spring will throw an error if you inject a scoped bean (`@RequestScope` or `@SessionScope`) into a singleton (like services or scheduled tasks).

---

## 🛠 Fix: Use Proxies with `proxyMode`

```java
@Component
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSession {  }
```

Now Spring injects a **proxy** into singleton beans, which dynamically resolves the correct session instance at runtime.

---

## 🔄 Injecting into `@Scheduled` or Async Components

These are not tied to a web request or session, so injecting `@RequestScope` or `@SessionScope` directly won't work.

### 💡 Solution: Use `ObjectFactory`, `Provider`, or `ApplicationContext`

#### ✅ Using `ObjectFactory`

```java
@Component
public class SomeService {

    @Autowired
    private ObjectFactory<RequestData> requestDataFactory;

    public void process() {
        RequestData data = requestDataFactory.getObject(); // Gets correct request-scoped bean
        System.out.println("Request ID: " + data.getRequestId());
    }
}
```

#### ✅ Using `Provider` (JSR-330)

```java
@Component
public class SomeService {

    @Autowired
    private Provider<RequestData> provider;

    public void process() {
        RequestData data = provider.get();
        // use data
    }
}
```

#### ✅ Using `ApplicationContext`

```java
@Component
public class SomeService {

    @Autowired
    private ApplicationContext context;

    public void process() {
        RequestData data = context.getBean(RequestData.class);
    }
}
```

---

## ✅ Summary

| Scenario                          | Solution                                             |
|-----------------------------------|------------------------------------------------------|
| Inject `@RequestScope`/`@SessionScope` into singleton | Use `proxyMode = TARGET_CLASS`                        |
| Use scoped beans in async/scheduled logic | Use `ObjectFactory`, `Provider`, or `ApplicationContext` |
| Want session-persistent data     | Use `@SessionScope`                                  |
| Request-only data                | Use `@RequestScope`                                  |


Absolutely! Let's go deep into **`@Transactional`** in Spring—what it is, how it works, when to use it, when it fails, and how to handle it properly, especially from an interview perspective.

---

## 🔍 What is `@Transactional`?

`@Transactional` is a Spring annotation that **manages transactions declaratively**. It tells Spring to wrap the annotated method or class in a **database transaction**—automatically beginning, committing, or rolling back based on success/failure.

---

## ✅ Why Do We Use `@Transactional`?

- To ensure **data integrity and consistency**.
- To perform **atomic** operations—either all changes succeed or none.
- To simplify **transaction management**—no manual begin/commit/rollback.

---

## 🛠️ Example

```java
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void transferMoney(Long fromId, Long toId, BigDecimal amount) {
        Account from = accountRepository.findById(fromId).get();
        Account to = accountRepository.findById(toId).get();

        from.setBalance(from.getBalance().subtract(amount));
        to.setBalance(to.getBalance().add(amount));

        accountRepository.save(from);
        accountRepository.save(to);
    }
}
```

> 💥 If an exception occurs mid-way, the whole transaction is **rolled back**.

---

## ⚙️ Internal Working (Under the Hood)

- Spring uses **AOP (Aspect-Oriented Programming)** to wrap the method in a **proxy**.
- When a `@Transactional` method is called:
    - Spring opens a DB connection (via a `TransactionManager`).
    - On successful completion → **commit**.
    - On runtime exception → **rollback**.

---

## ❌ When Does `@Transactional` NOT Work?

### 1. **Self-invocation**

```java
@Transactional
public void outer() {
    inner(); // Calls another method in same class
}

@Transactional
public void inner() {  }  // ❌ No transaction will be applied here
```

> ❗ Because it bypasses Spring proxy.

✅ **Fix**: Move the inner method to another bean/service.

---

### 2. **Called Before Spring Proxy Initialized**

```java
@PostConstruct
@Transactional
public void init() {
   // ❌ Transaction won't work here
}
```

> Spring's proxy not yet active during `@PostConstruct`.

---

### 3. **Checked Exceptions (by default)**

```java
@Transactional
public void doSomething() throws IOException {
    throw new IOException("Checked exception");  // ❌ No rollback
}
```

> Only **unchecked (Runtime) exceptions trigger rollback** by default.

✅ **Fix**:


@Transactional(rollbackFor = IOException.class)


---

### 4. **Wrong Propagation or Isolation Settings**

Misusing `@Transactional(propagation = Propagation.NOT_SUPPORTED)` might disable the transaction entirely.

---

## 🔄 Transaction Propagation Types

| Type              | Meaning                                                  |
|-------------------|----------------------------------------------------------|
| `REQUIRED`        | Default. Use existing or create new transaction.         |
| `REQUIRES_NEW`    | Always create a new transaction.                         |
| `NESTED`          | Savepoint inside current transaction.                    |
| `SUPPORTS`        | Join if one exists, else no transaction.                 |
| `MANDATORY`       | Must join existing transaction.                          |
| `NOT_SUPPORTED`   | Executes **outside** of a transaction.                   |
| `NEVER`           | Fails if transaction exists.                             |

---

## ⚙️ Isolation Levels

| Isolation Level     | Description                                              |
|----------------------|----------------------------------------------------------|
| `READ_UNCOMMITTED`   | Can read uncommitted changes (dirty read)               |
| `READ_COMMITTED`     | Default in many DBs (no dirty reads)                    |
| `REPEATABLE_READ`    | Same query returns same results during transaction      |
| `SERIALIZABLE`       | Fully isolated, slowest, avoids phantom reads           |

---

## ✅ Best Practices

1. **Use on service layer methods**, not DAOs or controllers.
2. Prefer **checked exceptions for business logic** and configure rollback explicitly.
3. Keep transactional methods **short** and focused.
4. Avoid calling `@Transactional` methods from within the same class.

---

## ✅ Pros and Cons

### ✅ Pros
- Declarative, no boilerplate
- Handles rollback automatically
- Supports nested and complex transaction management

### ❌ Cons
- Silent failures (e.g., self-invocation)
- Debugging can be tricky
- Improper configuration leads to no rollback

---

## 🧠 Interview-Specific Tips

### Common Interview Questions
- What does `@Transactional` do internally?
- When does it fail?
- How does Spring decide when to rollback?
- Difference between `REQUIRED` and `REQUIRES_NEW`?
- How would you handle self-invocation?

### Suggested Answers
- Always mention **proxy-based AOP**.
- Talk about **rollback on RuntimeException**, and how to configure `rollbackFor`.
- Explain how **method visibility (must be `public`)** affects it.
- Describe **alternatives like programmatic transactions (using `TransactionTemplate`)** when declarative ones fall short.



