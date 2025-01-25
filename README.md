Here is the refactored `README.md` with proper headings and formatting:

---

# Understanding `Callable` and `Runnable` in Java

`Callable` and `Runnable` are two interfaces in Java commonly used to represent tasks that can be executed by a thread. They are pivotal in multithreading and concurrent programming. This guide explains their characteristics, usage, and differences.

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

`Callable` is a functional interface introduced in Java 5 under `java.util.concurrent`. It provides a method for executing tasks:

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
            e.printStackTrace();
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

| Feature               | Runnable                  | Callable                  |
|-----------------------|---------------------------|---------------------------|
| Method Signature      | `void run()`              | `V call() throws Exception` |
| Return Value          | None                      | Result of type `V`         |
| Exception Handling    | No checked exceptions     | Supports checked exceptions |
| Use Case              | Fire-and-forget tasks     | Tasks requiring results or exception handling |
| API Integration       | `Thread`, `ExecutorService` | `ExecutorService`         |

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
Unchecked exceptions are exceptions that are not checked at compile time. These occur due to programming errors and are subclasses of `RuntimeException`.

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

| **Aspect**             | **Checked Exceptions**                       | **Unchecked Exceptions**                 |  
|-------------------------|----------------------------------------------|------------------------------------------|  
| **Compile-Time Check**  | Yes, must be declared or handled.            | No, not checked at compile time.         |  
| **Declaration in throws** | Required.                                  | Not required.                            |  
| **Propagation**         | Explicit handling or declaration required.   | Propagates automatically.                |  
| **Examples**            | `IOException`, `SQLException`.              | `NullPointerException`, `ArithmeticException`. |  

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

| **Feature**       | **join**                                    | **wait**                                  |  
|--------------------|---------------------------------------------|-------------------------------------------|  
| **Defined In**     | `Thread` class                             | `Object` class                            |  
| **Purpose**        | Waits for a thread to finish execution.    | Waits for a notification from another thread. |  
| **Synchronization** | Not required.                             | Requires synchronization (`synchronized`). |  
| **How to Notify**  | Not applicable.                            | Use `notify()` or `notifyAll()`.          |  

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
                    e.printStackTrace();
                }
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

| **Method**         | **Purpose**                                  | **Defined In** |  
|---------------------|----------------------------------------------|----------------|  
| `sleep()`           | Pauses thread execution for a specified time. | `Thread` class |  
| `yield()`           | Suggests giving other threads a chance to run. | `Thread` class |  
| `interrupt()`       | Interrupts a thread in blocking operations.   | `Thread` class |  
| `isAlive()`         | Checks if a thread is alive.                  | `Thread` class |  

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
  ```java
  public static void sleep(long millis) throws InterruptedException
  ```
- **Example**:
  ```java
  public class SleepExample {
      public static void main(String[] args) throws InterruptedException {
          System.out.println("Main thread sleeping...");
          Thread.sleep(2000); // Sleep for 2 seconds
          System.out.println("Main thread resumes after sleep.");
      }
  }
  ```

---

### 2. **yield()**
- **Purpose**: Suggests that the current thread is willing to yield its execution to other threads of the same priority.
- **Defined In**: `Thread` class.
- **Method Signature**:
  ```java
  public static void yield()
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
  public void interrupt()
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
  public final boolean isAlive()
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
5. Prefer higher-level concurrency APIs like `ExecutorService` and `CompletableFuture` over manual thread management where possible.

---

## Conclusion

Understanding Java exceptions and thread methods is crucial for writing robust and efficient multithreaded applications. By mastering these concepts, you can handle errors effectively and manage threads efficiently.

# Differences in Java Multithreading Concepts

### 1. Difference Between `Thread` and `Runnable`

| **Aspect**               | **Thread**                                 | **Runnable**                             |
|--------------------------|--------------------------------------------|------------------------------------------|
| **Inheritance**          | Extends the `Thread` class.               | Implements the `Runnable` interface.     |
| **Flexibility**          | Can’t extend another class (Java doesn’t support multiple inheritance). | Can extend another class as it only implements `Runnable`. |
| **Usage**                | Creates a new thread directly.            | Requires passing an instance to a `Thread` object. |
| **Example**              | `class MyThread extends Thread {}`        | `class MyRunnable implements Runnable {}` |

---

### 2. Difference Between `start()` and `run()`

| **Aspect**               | **start()**                                | **run()**                                |
|--------------------------|--------------------------------------------|------------------------------------------|
| **Thread Execution**     | Creates a new thread and invokes `run()`. | Executes `run()` in the current thread.  |
| **Concurrency**          | Code runs in a separate thread.           | Code runs in the calling thread.         |
| **Usage**                | Used to start a new thread.               | Used when no multithreading is needed.   |
| **Example**              | `thread.start();`                         | `thread.run();`                          |

---

### 3. Difference Between `synchronized` and `Lock`

| **Aspect**               | **synchronized**                          | **Lock**                                 |
|--------------------------|--------------------------------------------|------------------------------------------|
| **Type**                 | Implicit locking.                         | Explicit locking (`ReentrantLock`).      |
| **Interruptibility**     | Not interruptible.                        | Can be interrupted (`lockInterruptibly()`). |
| **Performance**          | Less flexible but easier to use.          | Provides better performance under contention. |
| **Try Lock**             | Not possible.                             | Supported using `tryLock()`.             |
| **Unlocking**            | Automatic unlocking after block execution.| Requires explicit unlocking.             |
| **Example**              | `synchronized(obj) {}`                    | `lock.lock(); // Critical section lock.unlock();` |

---

### 4. Difference Between `volatile` and `synchronized`

| **Aspect**               | **volatile**                              | **synchronized**                         |
|--------------------------|--------------------------------------------|------------------------------------------|
| **Purpose**              | Ensures visibility of variable changes across threads. | Ensures mutual exclusion and visibility. |
| **Locking**              | No locking mechanism.                     | Provides locking mechanism.              |
| **Thread Safety**        | Doesn’t guarantee atomicity.              | Guarantees atomicity.                    |
| **Usage**                | For flags or status variables.            | For critical sections with complex operations. |
| **Example**              | `volatile boolean flag = true;`           | `synchronized void method() {}`          |

---

### 5. Difference Between `Thread` and `Process`

| **Aspect**               | **Thread**                                | **Process**                              |
|--------------------------|--------------------------------------------|------------------------------------------|
| **Definition**           | Lightweight unit of execution within a process. | Independent unit of execution.           |
| **Memory**               | Shares memory with other threads in the same process. | Has its own memory space.                |
| **Communication**        | Easier (shared memory).                   | More complex (Inter-Process Communication). |
| **Overhead**             | Lower.                                    | Higher due to memory and resource allocation. |

---

### 6. Difference Between Thread Pool (`ExecutorService`) and Creating Threads

| **Aspect**               | **Thread Pool (`ExecutorService`)**       | **Creating Threads**                     |
|--------------------------|--------------------------------------------|------------------------------------------|
| **Performance**          | Efficient for large numbers of tasks.     | Expensive for a large number of threads. |
| **Reuse**                | Reuses threads to reduce overhead.        | Creates new threads every time.          |
| **Management**           | Managed via APIs like `submit()` or `shutdown()`. | Manually managed (e.g., `start()`, `join()`). |
| **Example**              | `ExecutorService executor = Executors.newFixedThreadPool(5);` | `Thread thread = new Thread();`          |

---

### 7. Difference Between `Runnable` and `Callable`

| **Aspect**               | **Runnable**                              | **Callable**                             |
|--------------------------|--------------------------------------------|------------------------------------------|
| **Return Type**          | Doesn’t return a result (`void`).          | Returns a result (`Future<V>`).          |
| **Exception Handling**   | Can’t throw checked exceptions.            | Can throw checked exceptions.            |
| **Introduced In**        | Java 1.0.                                 | Java 5 (with `java.util.concurrent`).    |
| **Usage**                | Suitable for simple tasks.                | Suitable for tasks needing results.      |
| **Example**              | `Thread t = new Thread(new RunnableTask());` | `Future<Integer> result = executor.submit(new CallableTask());` |

---

### 8. Difference Between `wait()` and `sleep()`

| **Aspect**               | **wait()**                                | **sleep()**                              |
|--------------------------|--------------------------------------------|------------------------------------------|
| **Belongs To**           | Object class.                             | Thread class.                            |
| **Purpose**              | Releases the lock and waits for notification. | Pauses execution for a specified time.   |
| **Lock Handling**        | Releases the lock it holds.               | Doesn’t release any locks.               |
| **Usage**                | Used for inter-thread communication.      | Used for making a thread sleep.          |
| **Example**              | `wait();`                                 | `Thread.sleep(1000);`                    |

---

### 9. Difference Between Deadlock and Starvation

| **Aspect**               | **Deadlock**                              | **Starvation**                           |
|--------------------------|--------------------------------------------|------------------------------------------|
| **Definition**           | Two or more threads wait indefinitely for each other. | A thread waits indefinitely because higher-priority threads are running. |
| **Cause**                | Circular dependency on resources.         | Resource scheduling unfairness.          |
| **Prevention**           | Avoid nested locks, apply timeout.        | Use fair scheduling policies.            |

---

### 10. Difference Between `notify()` and `notifyAll()`

| **Aspect**               | **notify()**                              | **notifyAll()**                          |
|--------------------------|--------------------------------------------|------------------------------------------|
| **Purpose**              | Wakes up one waiting thread.              | Wakes up all waiting threads.            |
| **Efficiency**           | More efficient as it wakes only one thread. | Less efficient but ensures no thread is left waiting. |
| **Usage**                | Use when you know which thread to wake.   | Use when all threads need to continue.   |

---

### Comparable vs Comparator in Java


Use `Comparable` when you want to define a natural ordering for the objects of a class. This is done by implementing the `Comparable` interface and overriding the `compareTo` method. This approach is suitable when the class has a single, natural way of ordering its instances.

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

Use `Comparator` when you want to define multiple ways of ordering objects, or when you want to define an ordering for a class that does not have a natural ordering. This is done by creating a class that implements the `Comparator` interface and overriding the `compare` method.

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