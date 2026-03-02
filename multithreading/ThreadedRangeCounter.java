package multithreading;
/**
 * ThreadedRangeCounter demonstrates counting from 1 to a user-given limit using multiple threads.
 * Each thread handles a portion of numbers and synchronization ensures correct order of printing.
 * It uses wait() and notifyAll() to coordinate threads and avoid race conditions.
 * Includes basic input validation and error handling.
 */
import java.util.Scanner;

public class ThreadedRangeCounter {

    private static int current = 1; // shared counter
    private static int limit;       // maximum number to count till
    private static final Object lock = new Object();

    // Worker thread responsible for printing numbers belonging to its slot
    static class CounterWorker extends Thread {
        private final int threadId;
        private final int totalThreads;

        CounterWorker(int threadId, int totalThreads) {
            this.threadId = threadId;
            this.totalThreads = totalThreads;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (current <= limit && (current - 1) % totalThreads != threadId) {
                        try {
                            lock.wait(); // wait until it's this thread's turn
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    if (current > limit) {
                        lock.notifyAll();
                        return;
                    }

                    System.out.println("Thread-" + threadId + " counted: " + current);
                    current++;
                    lock.notifyAll(); // wake up other threads
                }
            }
        }
    }

    // Creates and starts threads based on the given limit
    private static void startCounting(int threadCount) {
        CounterWorker[] workers = new CounterWorker[threadCount];
        for (int i = 0; i < threadCount; i++) {
            workers[i] = new CounterWorker(i, threadCount);
            workers[i].start();
        }

        for (CounterWorker worker : workers) {
            try {
                worker.join(); // ensure main waits for all threads
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Entry point to take input and initiate threaded counting
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter counting limit: ");
            limit = scanner.nextInt();

            if (limit <= 0) {
                System.out.println("Limit must be positive.");
                return;
            }

            int threadCount = Math.min(4, limit); // use up to 4 threads
            startCounting(threadCount);

            System.out.println("Counting completed successfully.");
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter an integer.");
        } finally {
            scanner.close();
        }
    }
}