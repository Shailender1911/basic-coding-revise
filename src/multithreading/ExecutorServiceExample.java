package multithreading;

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
