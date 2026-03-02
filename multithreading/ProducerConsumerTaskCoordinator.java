package multithreading;
/**
 * ProducerConsumerTaskCoordinator demonstrates producer and consumer threads using a shared queue.
 * The producer generates integer tasks and adds them to the queue, while the consumer processes them.
 * Synchronization with wait() and notifyAll() ensures safe communication without race conditions.
 * Includes basic error handling and clear console output of produced and consumed tasks.
 */
import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerTaskCoordinator {

    private static final Queue<Integer> queue = new LinkedList<>();
    private static final int MAX_SIZE = 5;
    private static final Object lock = new Object();
    private static final int TOTAL_TASKS = 20;

    // Producer thread generates integer tasks and adds them to the shared queue
    static class Producer extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 1; i <= TOTAL_TASKS; i++) {
                    synchronized (lock) {
                        while (queue.size() == MAX_SIZE) {
                            lock.wait(); // wait if queue is full
                        }
                        queue.add(i);
                        System.out.println("Produced task: " + i);
                        lock.notifyAll(); // notify consumer
                    }
                    Thread.sleep(100); // simulate production delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer interrupted.");
            }
        }
    }

    // Consumer thread removes and processes tasks from the shared queue
    static class Consumer extends Thread {
        @Override
        public void run() {
            int consumedCount = 0;
            try {
                while (consumedCount < TOTAL_TASKS) {
                    synchronized (lock) {
                        while (queue.isEmpty()) {
                            lock.wait(); // wait if queue is empty
                        }
                        int task = queue.poll();
                        System.out.println("Consumed task: " + task);
                        consumedCount++;
                        lock.notifyAll(); // notify producer
                    }
                    Thread.sleep(150); // simulate processing delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer interrupted.");
            }
        }
    }

    // Entry point creates and starts producer and consumer threads
    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        producer.start();
        consumer.start();

        try {
            producer.join(); // wait for producer to finish
            consumer.join(); // wait for consumer to finish
            System.out.println("All tasks produced and consumed successfully.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Execution interrupted.");
        }
    }
}