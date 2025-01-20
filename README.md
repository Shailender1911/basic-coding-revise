`Callable` and `Runnable` are two interfaces in Java commonly used for representing tasks that can be executed by a thread. They are often used in multithreading and concurrent programming. While they serve similar purposes, there are important distinctions between them that influence when and how to use each.

---

## **Runnable**
### **Definition**
`Runnable` is a functional interface that represents a task to be executed by a thread. It has a single method:
```java
void run();
```
### **Characteristics**
- Does not return a result.
- Cannot throw checked exceptions (you can only throw unchecked exceptions).
- Commonly used when no result is needed from the task.

### **Usage**
Use `Runnable` when the task does not need to return a result or throw checked exceptions.

#### **Example**
```java
public class RunnableExample {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Task is running...");
        
        Thread thread = new Thread(task);
        thread.start();
    }
}
```

#### **Pros**
1. **Simple to use**: Easier to implement when the task is straightforward.
2. **Good for fire-and-forget tasks**: No need to deal with return values.
3. **Widely supported**: Used extensively in legacy code and existing frameworks.

#### **Cons**
1. **No result**: Cannot return a value after execution.
2. **No checked exceptions**: You must handle exceptions internally.
3. **Less flexible**: Limited in scenarios where a result or exception handling is essential.

---

## **Callable**
### **Definition**
`Callable` is a functional interface introduced in Java 5 under `java.util.concurrent`. It has a single method:
```java
V call() throws Exception;
```

### **Characteristics**
- Returns a result of type `V`.
- Can throw checked exceptions.
- Commonly used with `ExecutorService` to submit tasks.

### **Usage**
Use `Callable` when the task needs to return a result or throw checked exceptions.

#### **Example**
```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> task = () -> {
            Thread.sleep(2000); // Simulate some work
            return "Task completed!";
        };

        Future<String> future = executor.submit(task);

        try {
            System.out.println("Result: " + future.get()); // Blocks until the task is complete
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
```

#### **Pros**
1. **Returns a result**: Makes it easy to get the output of a task.
2. **Checked exceptions**: Allows throwing checked exceptions, making error handling more robust.
3. **Flexible**: Works seamlessly with modern concurrency frameworks like `ExecutorService`.

#### **Cons**
1. **More complex**: Requires managing `Future` and `ExecutorService` for task execution.
2. **Blocking**: Using `Future.get()` blocks the thread until the result is ready unless handled asynchronously.
3. **Overhead**: Slightly more resource-intensive due to additional return value handling.

---

## **Comparison**
| Feature               | `Runnable`                  | `Callable`                  |
|-----------------------|-----------------------------|-----------------------------|
| Method Signature      | `void run()`                | `V call() throws Exception` |
| Return Value          | None                        | Result of type `V`          |
| Exception Handling    | Cannot throw checked exceptions | Can throw checked exceptions |
| Use Case              | Fire-and-forget tasks       | Tasks requiring results or exceptions |
| API Integration       | `Thread`, `ExecutorService` | `ExecutorService`           |

---

## **When to Use Which**
1. **Use `Runnable`**:
    - For simple tasks like logging, notifications, or other fire-and-forget operations.
    - When no result or exception handling is required.
    - For lightweight and legacy threading use cases.

2. **Use `Callable`**:
    - For tasks requiring a result (e.g., fetching data from a database or a service).
    - When you need to handle checked exceptions gracefully.
    - For modern multithreading scenarios with frameworks like `ExecutorService`.

---

### **Practical Example**
**Scenario**: Calculate the sum of numbers from 1 to 100 in two ways:
1. Using `Runnable` (result stored externally).
2. Using `Callable` (result returned directly).

#### **Runnable Example**
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
        thread.join(); // Wait for the thread to finish

        System.out.println("Sum: " + result);
    }
}
```

#### **Callable Example**
```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
            System.out.println("Sum: " + future.get()); // Retrieve the result
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
```

---

## **Key Points**
- Prefer `Runnable` for lightweight, non-blocking, and simple tasks.
- Use `Callable` for tasks requiring results or proper exception handling.
- Modern Java practices favor `Callable` in conjunction with `ExecutorService` for robust, scalable concurrency.


In Java, exceptions are categorized into **checked exceptions** and **unchecked exceptions**, and their behavior in propagation is different.

---

### **Checked Exceptions**
#### Definition:
- Checked exceptions are exceptions that are **checked at compile time**.
- The compiler forces the programmer to either handle these exceptions (using `try-catch`) or declare them in the method signature (`throws`).

#### Examples:
- `IOException`
- `SQLException`
- `InterruptedException`

#### Propagation of Checked Exceptions:
1. If a method throws a checked exception, it must declare this in its `throws` clause.
2. The exception will propagate up the call stack until it is handled by a `try-catch` block or terminates the program (if not handled at all).

#### Example:
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

In this example:
1. `methodB()` throws a checked exception.
2. `methodA()` propagates the exception by declaring it in its `throws` clause.
3. The `main()` method handles it using a `try-catch` block.

---

### **Unchecked Exceptions**
#### Definition:
- Unchecked exceptions are exceptions that are **not checked at compile time**.
- These exceptions occur due to programming errors and are subclasses of `RuntimeException`.

#### Examples:
- `NullPointerException`
- `ArrayIndexOutOfBoundsException`
- `IllegalArgumentException`

#### Propagation of Unchecked Exceptions:
- Unchecked exceptions do not need to be declared in the `throws` clause of a method.
- If not handled, they will propagate up the call stack automatically until they reach the JVM, which will terminate the program.

#### Example:
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

In this example:
1. `methodB()` throws an unchecked exception (`NullPointerException`).
2. `methodA()` does not need a `throws` clause because unchecked exceptions are not checked at compile time.
3. The `main()` method handles the exception using a `try-catch` block.

---

### **Key Differences in Propagation**

| Aspect                      | Checked Exceptions                | Unchecked Exceptions                |
|-----------------------------|------------------------------------|-------------------------------------|
| **Compile-Time Check**       | Yes, must be declared or handled. | No, not checked at compile time.    |
| **Declaration in `throws`**  | Required.                        | Not required.                       |
| **Propagation**              | Explicit handling required at every level, or declaration in `throws`. | Propagates automatically up the call stack until caught or terminates the program. |
| **Examples**                 | `IOException`, `SQLException`.   | `NullPointerException`, `ArithmeticException`. |

---

### **Practical Use Cases**
1. **Checked Exceptions**: Use for predictable, recoverable scenarios, such as:
    - File not found (`IOException`).
    - Database connectivity issues (`SQLException`).

   Example:
   ```java
   void readFile() throws IOException {
       Files.readAllLines(Paths.get("nonexistent.txt"));
   }
   ```

2. **Unchecked Exceptions**: Use for programming errors or invalid states, such as:
    - Null pointer dereference (`NullPointerException`).
    - Invalid arguments (`IllegalArgumentException`).

   Example:
   ```java
   void divide(int a, int b) {
       if (b == 0) throw new ArithmeticException("Cannot divide by zero");
       System.out.println(a / b);
   }
   ```

---

### **Best Practices**
1. **Checked Exceptions**:
    - Use them for conditions that a program can reasonably recover from.
    - Always handle them or declare them explicitly in the `throws` clause.

2. **Unchecked Exceptions**:
    - Use them for programming logic errors that should be fixed rather than recovered from.
    - Avoid overusing unchecked exceptions for situations that are not truly exceptional.

By understanding the difference and propagation behavior of these exception types, you can write robust and maintainable Java programs.


Here's a detailed explanation in the form of a `README.md` file, covering `join` vs `wait` and other important methods of the `Thread` class in Java.

---

# Java Thread Class: `join`, `wait`, and Other Important Methods

Java's `Thread` class provides powerful tools for multithreading. This document explains the commonly asked methods of the `Thread` class in interviews, with a focus on `join` vs `wait`.

---

## Table of Contents

1. [Thread Class Basics](#thread-class-basics)
2. [join vs wait](#join-vs-wait)
   - [Key Differences](#key-differences)
   - [When to Use](#when-to-use)
3. [Other Important Thread Methods](#other-important-thread-methods)
4. [Examples of Commonly Asked Methods](#examples-of-commonly-asked-methods)
5. [Best Practices](#best-practices)

---

## Thread Class Basics

- The `Thread` class in Java belongs to the `java.lang` package.
- It is used to create and manage threads in multithreaded applications.

---

## join vs wait

### **join()**
- **Purpose**: Ensures that the current thread waits for another thread to complete.
- **Defined In**: `Thread` class.
- **Usage**: Useful when one thread depends on the completion of another.
- **Method Signature**:
  ```java
  public final void join() throws InterruptedException
  public final void join(long millis) throws InterruptedException
  ```
- **Example**:
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

### **wait()**
- **Purpose**: Causes the current thread to wait until another thread notifies it.
- **Defined In**: `Object` class.
- **Usage**: Synchronization between threads, typically used with `notify()` or `notifyAll()`.
- **Method Signature**:
  ```java
  public final void wait() throws InterruptedException
  public final void wait(long timeout) throws InterruptedException
  public final void wait(long timeout, int nanos) throws InterruptedException
  ```
- **Example**:
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

### Key Differences

| Feature                  | `join`                                    | `wait`                                   |
|--------------------------|-------------------------------------------|------------------------------------------|
| **Defined In**            | `Thread` class                           | `Object` class                           |
| **Purpose**               | Waits for a thread to finish execution   | Waits for a notification from another thread |
| **Synchronization**       | Not required                             | Requires synchronization (inside a synchronized block) |
| **How to Notify**         | Not applicable                          | Use `notify()` or `notifyAll()`          |
| **Example Use Case**       | Waiting for a thread to complete         | Implementing producer-consumer problems |

---

### When to Use

- **Use `join`**:
   - When a thread must wait for another thread to complete.
   - Example: A main thread waiting for a worker thread to finish a task before proceeding.

- **Use `wait`**:
   - When implementing inter-thread communication.
   - Example: Producer-consumer scenarios where threads must coordinate their execution.

---

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

The `Thread` class provides various methods to manage threads effectively. Understanding when and how to use these methods, especially `join` and `wait`, is crucial for building robust and efficient multithreaded applications.