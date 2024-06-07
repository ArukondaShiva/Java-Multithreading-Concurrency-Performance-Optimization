
public class ThreadInterrupt{

    public static void main(String[] args) {
        
        Thread thread = new Thread(new BlockingTask());

        thread.start();

        // interrupting the thread  -> InterruptedException 
        thread.interrupt();

    }

    private static class BlockingTask implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Exiting the block...");
            }
        }

    }

}
