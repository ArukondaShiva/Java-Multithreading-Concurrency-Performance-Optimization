import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadForRequestIOBoundV1 {

    private static final int NUMBER_OF_TASKS = 1000;

    public static void main(String[] args) {

        // N Threads assigned to N cores of CPU --> 1 request is served by 1 core
        // if request takes time to complete IO operations and
        // Threads are more than the cores, these time taking IO operations make the CPU idle.

         // Thrashing - is a situation where most of the cpu time spent of making context switches rather than doing the actual job.


        /*
         * Threads Per Task 
         * it has been standard for many decades
         * it will not give optimal performance and cpu utilization.
         * 
         * --> positive : concurrency
         * --> Negatives :
         *     - can create limited number of threads
         *     - too many threads --> application crashes
         *     - too few threads --> poor performance.
         *     - potential thrashing
         * 
         * 
         * does not give optimal performance when 
         *       - When a thread is blocking an IO, it cannot be used
         *       - Requires us to allocate more threads
         *       - consuming more resources
         *       - adding context-switches overhead
         * 
         */


        Scanner s = new Scanner(System.in);
        System.out.println("Press enter to start");
        s.nextLine();
        System.out.printf("Running %d tasks\n", NUMBER_OF_TASKS);

        long start = System.currentTimeMillis();
        performTasks();
        System.out.printf("Tasks took %dms to complete\n", NUMBER_OF_TASKS);

    }

    private static void performTasks() {

        try (ExecutorService executorService = Executors.newFixedThreadPool(1000)) {

            for (int i = 0; i < NUMBER_OF_TASKS; i++) {
                executorService.submit(new Runnable() {

                    @Override
                    public void run() {
                        blockingIOOperation();
                    }
                });
            }
        }

    }

    // simulate a long blocking IO
    private static void blockingIOOperation() {
        System.out.println("Executing a blocking task from thread : " + Thread.currentThread());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

}
