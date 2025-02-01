package multithreading;

import java.util.concurrent.ThreadPoolExecutor;

public class CallableExample {

    ThreadPoolExecutor executor;

    public CallableExample(ThreadPoolExecutor executor) {
        this.executor = executor;
    }

    public void execute() {
        executor.execute(() -> {
            System.out.println("Executing task");
        });
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = null;
        CallableExample callableExample = new CallableExample(executor);
        callableExample.execute();
    }
}
