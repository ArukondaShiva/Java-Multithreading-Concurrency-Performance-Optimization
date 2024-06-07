public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World");


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are in the new thread "+Thread.currentThread().getName());
                System.out.println("Current Thread Priority is "+Thread.currentThread().getPriority());
            }
        });

        thread.setName("New Worker thread");
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("We are in thread: "+Thread.currentThread().getName()+" before starting a new thread");
        thread.start();
        System.out.println("Wee are in thread: "+Thread.currentThread().getName()+" after starting a new thread");


    }

}
