package utils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author 王强
 * @since 2024/10/10
 */
public class BenchmarkUtils {

    private static final ExecutorService executorService;

    static {
        executorService = Executors.newFixedThreadPool(10);
    }

    public static void execute(int count, RunFunction runFunction) throws InterruptedException {
        AtomicLong timeConsuming = new AtomicLong(0L);
        CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            executorService.execute(() -> {
                long start = System.currentTimeMillis();
                runFunction.action();
                timeConsuming.addAndGet(System.currentTimeMillis() - start);
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("Method run times: " + count);
        System.out.println("Average time consumption: " + timeConsuming.get() / count);
        executorService.shutdown();
    }

}
