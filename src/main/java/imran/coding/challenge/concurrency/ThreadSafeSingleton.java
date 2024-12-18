package imran.coding.challenge.concurrency;

public class ThreadSafeSingleton {

    private static volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
    }

    /**
     * Creates a thread-safe singleton class
     * @return - ThreadSafeSingleton - A thread-safe singleton class
     */
    public static ThreadSafeSingleton getInstance() {

        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }

        return instance;
    }
}
