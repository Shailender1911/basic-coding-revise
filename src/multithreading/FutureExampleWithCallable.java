package multithreading;

import java.util.concurrent.*;

public class FutureExampleWithCallable {
    public static void main(String[] args) {

        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += i;
            }
            return sum;
        });

        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            System.out.println("Sum of first 5 numbers: " + futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }


}
