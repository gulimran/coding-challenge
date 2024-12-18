package imran.coding.challenge.concurrency;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;

class ThreadSafeSingletonTest {

    @Test
    void returnsAnInstanceOfClass() {
        assertThat(ThreadSafeSingleton.getInstance()).isNotNull();
    }

    @Test
    void returnsTheSameInstanceOfClassFromMultipleThreads() throws Exception  {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<ThreadSafeSingleton> getInstanceTask = ThreadSafeSingleton::getInstance;

        List<Future<ThreadSafeSingleton>> futures = new ArrayList<>(3);

        for (int i=0; i<3; i++) {
            Future<ThreadSafeSingleton> future = executor.submit(getInstanceTask);
            futures.add(future);
        }

        ThreadSafeSingleton instance1 = futures.get(0).get();
        ThreadSafeSingleton instance2 = futures.get(1).get();
        ThreadSafeSingleton instance3 = futures.get(2).get();
        executor.shutdown();

        assertThat(instance1).isNotNull();
        assertThat(instance2).isNotNull();
        assertThat(instance3).isNotNull();
        assertThat(instance3).isEqualTo(instance2).isEqualTo(instance1);
    }

}