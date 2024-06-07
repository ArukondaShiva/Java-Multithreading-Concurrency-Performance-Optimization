import java.util.ArrayList;
import java.util.List;

public class VirtualThreadDemo {

    private static final int NUMBER_OF_VIRTUAL_THREADS = 2;

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> System.out.println("Inside Thread : " + Thread.currentThread());

        /*
         * 
         * // explicit way of creating a platform thread
         * //Thread platformThread = Thread.ofPlatform().unstarted(runnable);
         * 
         * 
         * //explicit way of creating a virtual Thread
         * // Object will be created in JVM memory.
         * Thread virtualThread = Thread.ofVirtual().unstarted(runnable);
         * 
         * //output : Inside Thread :
         * VirtualThread[#21]/runnable@ForkJoinPool-1-worker-1
         * // JVM creates a thread pools of platform threads here, it created
         * "@ForkJoinPool-1", and this jvm mounted
         * // this virtual thread on one of those worker threads which is called
         * worker-1.
         * 
         * 
         * 
         * 
         * virtualThread.start();
         * virtualThread.join();
         * 
         * 
         */

        List<Thread> virtualThreads = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_VIRTUAL_THREADS; i++) {
            Thread virtualThread = Thread.ofVirtual().unstarted(runnable);
            virtualThreads.add(virtualThread);
        }

        for (Thread virtualThread : virtualThreads) {
            virtualThread.start();
        }

        for (Thread virtualThread : virtualThreads) {
            virtualThread.join();
        }

    }

}
