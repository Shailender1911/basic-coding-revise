package multithreading;

public class ProducerConsumerExample {


    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(5);
// creating producer and consumer threads
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    sharedResource.produce(i);
                } catch (InterruptedException e) {
                    System.out.println("Exception occurred in producer: " + e.getMessage());
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    sharedResource.consume();
                } catch (InterruptedException e) {
                    System.out.println("Exception occurred in consumer: " + e.getMessage());
                }
            }
        });

        producer.start();
        consumer.start();

    }






}