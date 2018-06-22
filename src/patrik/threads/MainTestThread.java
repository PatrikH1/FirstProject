package patrik.threads;

public class MainTestThread {

    public static void main(String[] args) {
        // testThreadStartAndStop();
        // testThreadTimeoutByThread();
        testThreadTimeoutByName();
    }

    private static void testThreadTimeoutByName() {
        Thread thread0 = new Thread(new TestThread());
        Thread thread1 = new Thread(new TestThread());

        System.out.println("Thread0" + printAliveOrNot(thread0));
        System.out.println("Thread1" + printAliveOrNot(thread1));

        System.out.println("Thread0 and thread1 starts!");
        thread0.start();
        thread1.start();
        delaySomeSeconds(1);
        System.out.println("Thread0" + printAliveOrNot(thread0));
        System.out.println("Thread1" + printAliveOrNot(thread1));

        System.out.println("Timeout on thread0 10 s");
        Thread timeoutThread0_10s = new Thread(new TimeoutThread(thread0.getName(), 10));
        timeoutThread0_10s.start();

        System.out.println("Timeout on thread1 5 s");
        Thread timeoutThread0_5s = new Thread(new TimeoutThread(thread1.getName(), 5));
        timeoutThread0_5s.start();

        delaySomeSeconds(15);

        System.out.println("Thread0" + printAliveOrNot(thread0));
        System.out.println("Thread1" + printAliveOrNot(thread1));
        System.out.println("timeoutThread0_10s" + printAliveOrNot(timeoutThread0_10s));
        System.out.println("timeoutThread0_5s" + printAliveOrNot(timeoutThread0_5s));
    }

    private static void testThreadTimeoutByThread() {
        Thread thread0 = new Thread(new TestThread());
        Thread thread1 = new Thread(new TestThread());

        System.out.println("Thread0" + printAliveOrNot(thread0));
        System.out.println("Thread1" + printAliveOrNot(thread1));

        System.out.println("Thread0 and thread1 starts!");
        thread0.start();
        thread1.start();
        delaySomeSeconds(1);
        System.out.println("Thread0" + printAliveOrNot(thread0));
        System.out.println("Thread1" + printAliveOrNot(thread1));

        System.out.println("Timeout on thread0 10 s");
        Thread timeoutThread0_10s = new Thread(new TimeoutThread(thread0, 10));
        timeoutThread0_10s.start();

        System.out.println("Timeout on thread1 5 s");
        Thread timeoutThread0_5s = new Thread(new TimeoutThread(thread1, 5));
        timeoutThread0_5s.start();

        delaySomeSeconds(15);

        System.out.println("Thread0" + printAliveOrNot(thread0));
        System.out.println("Thread1" + printAliveOrNot(thread1));
        System.out.println("timeoutThread0_10s" + printAliveOrNot(timeoutThread0_10s));
        System.out.println("timeoutThread0_5s" + printAliveOrNot(timeoutThread0_5s));
    }

    private static void testThreadStartAndStop() {

        Thread thread0 = new Thread(new TestThread());
        Thread thread1 = new Thread(new TestThread());

        System.out.println("Thread0" + printAliveOrNot(thread0));
        System.out.println("Thread1" + printAliveOrNot(thread1));

        System.out.println("Thread0 and thread1 starts!");
        thread0.start();
        thread1.start();
        delaySomeSeconds(1);
        System.out.println("Thread0" + printAliveOrNot(thread0));
        System.out.println("Thread1" + printAliveOrNot(thread1));


        delaySomeSeconds(3);
        System.out.println("Thread0 stops!");
        thread0.interrupt();
        delaySomeSeconds(1);
        System.out.println("Thread0" + printAliveOrNot(thread0));
        System.out.println("Thread1" + printAliveOrNot(thread1));

        delaySomeSeconds(3);
        System.out.println("Thread1 stops!");
        thread1.interrupt();
        delaySomeSeconds(1);
        System.out.println("Thread0" + printAliveOrNot(thread0));
        System.out.println("Thread1" + printAliveOrNot(thread1));

        System.out.println("Done!");

    }

    private static void delaySomeSeconds(int delay) {
        try {
            Thread.sleep(delay * 1000);
        }
        catch (InterruptedException ex) {
            System.out.println("Caught InterruptedException: " + ex.getMessage());
        }
    }

    private static String printAliveOrNot(Thread thread) {
        return thread.isAlive() ? " is alive!" : " is not alive!";
    }
}
