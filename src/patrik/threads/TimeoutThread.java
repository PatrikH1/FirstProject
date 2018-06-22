package patrik.threads;

public class TimeoutThread implements Runnable {
    private Thread thread = null;
    private String threadName = null;
    int delayInSeconds = 0;

    TimeoutThread(Thread thread, int delayInSeconds) {
        this.thread = thread;
        this.delayInSeconds = delayInSeconds;

    }

    TimeoutThread(String threadName, int delayInSeconds) {
        this.threadName = threadName;
        this.delayInSeconds = delayInSeconds;
    }

    public void run() {
        if (thread != null) {
            delaySomeSeconds(delayInSeconds);
            System.out.println("Thread " + thread.getName() + " will be interrupted!");
            thread.interrupt();
            return;
        }
        else if (threadName != null) {
            delaySomeSeconds(delayInSeconds);

            Thread threadToInterrupt = getThreadByName(threadName);
            if (threadToInterrupt != null) {
                System.out.println("Thread " + threadToInterrupt.getName() + " will be interrupted!");
                threadToInterrupt.interrupt();
                return;
            }
            return;
        }
        else {
            return;
        }

    }

    private void delaySomeSeconds(int delayInSeconds) {
        try {
            Thread.sleep(delayInSeconds * 1000);
        }
        catch (InterruptedException ex) {
            System.out.println("Caught InterruptedException: " + ex.getMessage());
        }
    }

    private Thread getThreadByName(String threadName) {
        for (Thread t : Thread.getAllStackTraces().keySet()) {
            if (t.getName().equals(threadName)) return t;
        }
        return null;
    }

}
