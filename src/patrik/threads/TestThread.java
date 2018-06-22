package patrik.threads;

public class TestThread implements Runnable {

    public void run() {
        Thread thread = Thread.currentThread();
        while (true) {
            try {
                System.out.println("This is thread: " + thread.getName());
                Thread.sleep(1000);
            }
            catch (InterruptedException ex) {
                System.out.println("Caught InterruptedException: " + ex.getMessage());
                return;
            }
        }
    }
}
